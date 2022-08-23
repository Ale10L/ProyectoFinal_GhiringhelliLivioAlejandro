package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.Entidades.Skills;
import com.portfolio.alejandro.Interfaces.ISkillsService;
import java.math.BigDecimal;
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
public class SkillsController {
    @Autowired ISkillsService iskillsService;
    
    @GetMapping("personas/skills/traer")
    public List<Skills> getSkills(){
        return iskillsService.getSkills();
    }
    
    @PostMapping("personas/skills/crear")
    public String createSkill(@RequestBody Skills skill){
        iskillsService.saveSkill(skill);
        return "Skill creada exitosamente";
    }
    
    @DeleteMapping("personas/skills/borrar/{id}")
    public String deleteSkils(@PathVariable Long id){
        iskillsService.deleteSkill(id);
        return "Skill eliminada correctamente";
    }
    
    @PutMapping("personas/skills/modificar/{id}")
    public String updateSkill(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("descripcion") String nuevaDescripcion,
                                @RequestParam("porcentaje") BigDecimal nuevoPorcentaje){
        Skills skill = iskillsService.findSkill(id);
        skill.setNombre(nuevoNombre);
        skill.setDescripcion(nuevaDescripcion);
        skill.setPorcentaje(nuevoPorcentaje);
        
        iskillsService.saveSkill(skill);
        return "Skill modificada correctamente";
    }
}
