package com.portfolio.alejandro.Controller;
import com.portfolio.alejandro.DTO.SkillhDTO;
import com.portfolio.alejandro.Entidades.Skillh;
import com.portfolio.alejandro.Security.Controller.Mensaje;
import com.portfolio.alejandro.Services.ImpSkillhService;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skillh")
@CrossOrigin(origins = "https://frontghiringhellialejandro.web.app/")
//@CrossOrigin(origins = "*")
public class SkillhController {
    @Autowired ImpSkillhService iskillhService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Skillh>> getSkillh(){
        List<Skillh> lista =  iskillhService.getSkillh();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/agregarskillh")
    public ResponseEntity<?> createSkill(@RequestBody SkillhDTO dtoskillh){
        if(StringUtils.isBlank(dtoskillh.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(iskillhService.existsByNombre(dtoskillh.getNombre())){
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skillh skillh = new Skillh(dtoskillh.getNombre(),dtoskillh.getDescripcion(), dtoskillh.getPorcentaje());
        
        iskillhService.saveSkill(skillh);
        return new ResponseEntity(new Mensaje("Educación creada exitosamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detalleskillh/{id}")
    public ResponseEntity<Skillh> findSkillh(@PathVariable Long id){
        if(!iskillhService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        Skillh skillh = iskillhService.getOne(id).get();
        return new ResponseEntity(skillh, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/borrarskillh/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id){
        if(!iskillhService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        iskillhService.deleteSkill(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editarskillh/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id,
                                         @RequestBody SkillhDTO dtoskillh){
        if(!iskillhService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.BAD_REQUEST);
        }
        
        if(iskillhService.existsByNombre(dtoskillh.getNombre()) && iskillhService.getByNombre(dtoskillh.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa skill ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(iskillhService.existsByNombre(dtoskillh.getNombre())){
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skillh skill = iskillhService.getOne(id).get();
        skill.setNombre(dtoskillh.getNombre());
        skill.setDescripcion(dtoskillh.getDescripcion());
        skill.setPorcentaje(dtoskillh.getPorcentaje());
        
        iskillhService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Skill modificada correctamente"), HttpStatus.OK);
    }
}
