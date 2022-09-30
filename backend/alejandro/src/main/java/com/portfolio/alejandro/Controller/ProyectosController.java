package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.DTO.ProyectosDTO;
import com.portfolio.alejandro.Entidades.Proyectos;
import com.portfolio.alejandro.Interfaces.IProyectosService;
import com.portfolio.alejandro.Security.Controller.Mensaje;
import com.portfolio.alejandro.Services.ImpProyectosService;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "https://frontghiringhellialejandro.web.app/")
//@CrossOrigin(origins = "*")
public class ProyectosController {
    @Autowired ImpProyectosService iproyectosService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Proyectos>> getProyectos(){
        List<Proyectos> lista = iproyectosService.getProyectos();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/agregarproyecto")
    public ResponseEntity<?> createProyecto(@RequestBody ProyectosDTO dtoproyecto){
        if(StringUtils.isBlank(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(iproyectosService.existsByNombre(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyecto = new Proyectos(dtoproyecto.getNombre(),dtoproyecto.getDescripcion(), dtoproyecto.getEnlace_proyecto());
        
        iproyectosService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado exitosamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detalleproyecto/{id}")
    public ResponseEntity<Proyectos> findProyecto(@PathVariable Long id){
        if(!iproyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyecto = iproyectosService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);    
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/borrarproyecto/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable Long id){
        if(!iproyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        iproyectosService.deleteProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editarproyecto/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id,
                                @RequestBody ProyectosDTO dtoproyecto){
        
        if(!iproyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.BAD_REQUEST);
        }
        
        if(iproyectosService.existsByNombre(dtoproyecto.getNombre()) && iproyectosService.getByNombre(dtoproyecto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(iproyectosService.existsByNombre(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyecto = iproyectosService.getOne(id).get();
        proyecto.setNombre(dtoproyecto.getNombre());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setEnlace_proyecto(dtoproyecto.getEnlace_proyecto());
        
        iproyectosService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto modificado correctamente"), HttpStatus.OK);
    }
}
