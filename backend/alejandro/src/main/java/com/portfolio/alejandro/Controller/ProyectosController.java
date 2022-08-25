package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.Entidades.Proyectos;
import com.portfolio.alejandro.Interfaces.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProyectosController {
    @Autowired IProyectosService iproyectosService;
    
    @GetMapping("personas/proyectos/traer")
    public List<Proyectos> getProyectos(){
        return iproyectosService.getProyectos();
    }
    
    @PostMapping("personas/proyectos/crear")
    public String createProyecto(@RequestBody Proyectos proyecto){
        iproyectosService.saveProyecto(proyecto);
        return "Proyecto creado exitosamente";
    }
    
    @DeleteMapping("personas/proyectos/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        iproyectosService.deleteProyecto(id);
        return "Proyecto eliminado correctamente";
    }
    
    @PutMapping("personas/proyectos/modificar/{id}")
    public String updateSkill(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("descripcion") String nuevaDescripcion,
                                @RequestParam("enlace_proyecto") String nuevoEnlace){
        Proyectos proyecto = iproyectosService.findProyecto(id);
        proyecto.setNombre(nuevoNombre);
        proyecto.setDescripcion(nuevaDescripcion);
        proyecto.setEnlace_proyecto(nuevoEnlace);
        
        iproyectosService.saveProyecto(proyecto);
        return "Proyecto modificado correctamente";
    }
}
