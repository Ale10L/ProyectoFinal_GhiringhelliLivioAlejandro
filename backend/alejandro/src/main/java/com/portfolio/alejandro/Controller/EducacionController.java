package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.Entidades.Educacion;
import com.portfolio.alejandro.Interfaces.IEducacionService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EducacionController {
    @Autowired IEducacionService ieducacionService;
    
    @GetMapping("personas/educacion/traer")
    public List<Educacion> getEducacion(){
        return ieducacionService.getEducacion();
    }
    
    @PostMapping("personas/educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        ieducacionService.saveEducacion(educacion);
        return "Educacion creada exitosamente";
    }
    
    @DeleteMapping("personas/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        ieducacionService.deleteEducacion(id);
        return "Educacion eliminada correctamente";
    }
    
    @PutMapping("personas/educacion/modificar/{id}")
    public String updateEducacion(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("lugar") String nuevoLugar,
                                @RequestParam("fecha_inicio") String nuevaFecha_Inicio,
                                @RequestParam("fecha_fin") String nuevaFecha_Fin) throws ParseException{
        Educacion educacion = ieducacionService.findEducacion(id);
        educacion.setNombre(nuevoNombre);
        educacion.setLugar(nuevoLugar);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        educacion.setFecha_inicio(formato.parse(nuevaFecha_Inicio));
        educacion.setFecha_fin(formato.parse(nuevaFecha_Fin));
        
        ieducacionService.saveEducacion(educacion);
        return "Educacion modificada correctamente";
    }
    
}
