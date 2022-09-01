package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.DTO.ExperienciaLaboralDTO;
import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import com.portfolio.alejandro.Security.Controller.Mensaje;
import com.portfolio.alejandro.Services.ImpExperienciaLaboralService;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "*")
public class ExperienciaLaboralController {
    @Autowired ImpExperienciaLaboralService iexperienciaService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<ExperienciaLaboral>> getExperienciaLaboral(){
        List<ExperienciaLaboral> lista = iexperienciaService.getExperienciaLaboral();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    /*@GetMapping("personas/experiencia-laboral/")
    public ExperienciaLaboral findExperienciaLaboral(){
        return iexperienciaService.findExperienciaLaboral((long)1);
    }*/
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> createExperienciaLaboral(@RequestBody ExperienciaLaboralDTO dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre de la experiencia laboral es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(iexperienciaService.existsByNombre(dtoexp.getNombre())){
            return new ResponseEntity(new Mensaje("Esa experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        ExperienciaLaboral experiencia = new ExperienciaLaboral(dtoexp.getNombre(),dtoexp.getDescripcion(), dtoexp.getFecha_inicio(),dtoexp.getFecha_fin());
        
        iexperienciaService.saveExperienciaLaboral(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia laboral creada exitosamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/experiencia-laboral/borrar/{id}")
    public ResponseEntity<?> deleteExperienciaLaboral(@PathVariable Long id){
        if(!iexperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
        iexperienciaService.deleteExperienciaLaboral(id);
        return new ResponseEntity(new Mensaje("Experiencia laboral eliminada correctamente"), HttpStatus.OK);
//        return "Experiencia laboral eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/experiencia-laboral/modificar/{id}")
    public ResponseEntity<?> updateExperienciaLaboral(@PathVariable Long id, 
                                                      @RequestBody ExperienciaLaboralDTO dtoexp) throws ParseException{
        
        if(!iexperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(iexperienciaService.existsByNombre(dtoexp.getNombre()) && iexperienciaService.getByNombre(dtoexp.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia laboral ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(iexperienciaService.existsByNombre(dtoexp.getNombre())){
            return new ResponseEntity(new Mensaje("Esa experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        }
        /*ExperienciaLaboral experiencia = iexperienciaService.findExperienciaLaboral(id);
        experiencia.setNombre(nuevoNombre);
        experiencia.setDescripcion(nuevaDescripcion);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        experiencia.setFecha_inicio(formato.parse(nuevaFecha_Inicio));
        experiencia.setFecha_fin(formato.parse(nuevaFecha_Fin));
        
        iexperienciaService.saveExperienciaLaboral(experiencia);
        return "Experiencia laboral modificada correctamente";*/
        ExperienciaLaboral experiencia = iexperienciaService.getOne(id).get();
        experiencia.setNombre(dtoexp.getNombre());
        experiencia.setDescripcion(dtoexp.getDescripcion());
        experiencia.setFecha_inicio(dtoexp.getFecha_inicio());
        experiencia.setFecha_fin(dtoexp.getFecha_fin());
        iexperienciaService.saveExperienciaLaboral(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia laboral modificada correctamente"), HttpStatus.OK);
    }
}
