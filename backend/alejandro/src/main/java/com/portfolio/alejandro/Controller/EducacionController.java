package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.DTO.EducacionDTO;
import com.portfolio.alejandro.Entidades.Educacion;
import com.portfolio.alejandro.Security.Controller.Mensaje;
import com.portfolio.alejandro.Services.ImpEducacionService;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edu")
@CrossOrigin(origins = "https://frontghiringhellialejandro.web.app/")
//@CrossOrigin(origins = "*")
public class EducacionController {
    @Autowired ImpEducacionService ieducacionService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Educacion>> getEducacion(){
         List<Educacion> lista = ieducacionService.getEducacion();
         return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/agregaredu")
    public ResponseEntity<?> createEducacion(@RequestBody EducacionDTO dtoedu){
        if(StringUtils.isBlank(dtoedu.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getNombre(),dtoedu.getLugar(), dtoedu.getFecha_inicio(),dtoedu.getFecha_fin());
        
        ieducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educación creada exitosamente"), HttpStatus.OK);
    }
    
    
    @GetMapping("/detalledu/{id}")
    public ResponseEntity<Educacion> findEducacion(@PathVariable Long id){
        if(!ieducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = ieducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);    
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/borraredu/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable Long id){
        if(!ieducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.BAD_REQUEST);
        }
        ieducacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editaredu/{id}")
    public ResponseEntity<?> updateEducacion(@PathVariable Long id,
                                @RequestBody EducacionDTO dtoedu) throws ParseException{
        
        if(!ieducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
        
        
        Educacion educacion = ieducacionService.getOne(id).get();
        educacion.setNombre(dtoedu.getNombre());
        educacion.setLugar(dtoedu.getLugar());
        educacion.setFecha_inicio(dtoedu.getFecha_inicio());
        educacion.setFecha_fin(dtoedu.getFecha_fin());
        ieducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educación modificada correctamente"), HttpStatus.OK);
    }
    
}
