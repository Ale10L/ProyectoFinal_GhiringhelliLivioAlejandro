package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import com.portfolio.alejandro.Interfaces.IExperienciaLaboralService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Convert;
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

public class ExperienciaLaboralController {
    @Autowired IExperienciaLaboralService iexperienciaService;
    
    @GetMapping("personas/experiencia-laboral/traer")
    public List<ExperienciaLaboral> getExperienciaLaboral(){
        return iexperienciaService.getExperienciaLaboral();
    }
    
    @GetMapping("personas/experiencia-laboral/")
    public ExperienciaLaboral findExperienciaLaboral(){
        return iexperienciaService.findExperienciaLaboral((long)1);
    }
    
    @PostMapping("personas/experiencia-laboral/crear")
    public String createExperienciaLaboral(@RequestBody ExperienciaLaboral experiencia){
        iexperienciaService.saveExperienciaLaboral(experiencia);
        return "Experiencia laboral creada exitosamente";
    }
    
    @DeleteMapping("personas/experiencia-laboral/borrar/{id}")
    public String deleteExperienciaLaboral(@PathVariable Long id){
        iexperienciaService.deleteExperienciaLaboral(id);
        return "Experiencia laboral eliminada correctamente";
    }
    
    @PutMapping("personas/experiencia-laboral/modificar/{id}")
    public String updateExperienciaLaboral(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("descripcion") String nuevaDescripcion,
                                @RequestParam("fecha_inicio") String nuevaFecha_Inicio,
                                @RequestParam("fecha_fin") String nuevaFecha_Fin) throws ParseException{
        ExperienciaLaboral experiencia = iexperienciaService.findExperienciaLaboral(id);
        experiencia.setNombre(nuevoNombre);
        experiencia.setDescripcion(nuevaDescripcion);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        experiencia.setFecha_inicio(formato.parse(nuevaFecha_Inicio));
        experiencia.setFecha_fin(formato.parse(nuevaFecha_Fin));
        
        iexperienciaService.saveExperienciaLaboral(experiencia);
        return "Experiencia laboral modificada correctamente";
    }
}
