package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.DTO.SkillsDTO;
import com.portfolio.alejandro.Entidades.Skills;
import com.portfolio.alejandro.Security.Controller.Mensaje;
import com.portfolio.alejandro.Services.ImpSkillsService;
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
@RequestMapping("skills")
@CrossOrigin(origins = "https://frontghiringhellialejandro.web.app/")
//@CrossOrigin(origins = "*")
public class SkillsController {
    @Autowired ImpSkillsService iskillsService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Skills>> getSkills(){
        List<Skills> lista =  iskillsService.getSkills();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/agregarskills")
    public ResponseEntity<?> createSkill(@RequestBody SkillsDTO dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(iskillsService.existsByNombre(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skills skillh = new Skills(dtoskills.getNombre(),dtoskills.getDescripcion(), dtoskills.getPorcentaje());
        
        iskillsService.saveSkill(skillh);
        return new ResponseEntity(new Mensaje("Educación creada exitosamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detalleskills/{id}")
    public ResponseEntity<Skills> findSkills(@PathVariable Long id){
        if(!iskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = iskillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/borrarskills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id){
        if(!iskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        iskillsService.deleteSkill(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editarskills/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id,
                                         @RequestBody SkillsDTO dtoskills){
        if(!iskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.BAD_REQUEST);
        }
        
        if(iskillsService.existsByNombre(dtoskills.getNombre()) && iskillsService.getByNombre(dtoskills.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa skill ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(iskillsService.existsByNombre(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skill = iskillsService.getOne(id).get();
        skill.setNombre(dtoskills.getNombre());
        skill.setDescripcion(dtoskills.getDescripcion());
        skill.setPorcentaje(dtoskills.getPorcentaje());
        
        iskillsService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Skill modificada correctamente"), HttpStatus.OK);
    }
}
