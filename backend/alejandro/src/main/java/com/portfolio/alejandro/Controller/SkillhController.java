/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandro.Controller;
import com.portfolio.alejandro.Entidades.Skillh;
import com.portfolio.alejandro.Interfaces.ISkillhService;
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
public class SkillhController {
    @Autowired ISkillhService iskillhService;
    
    @GetMapping("personas/skillh/traer")
    public List<Skillh> getSkillh(){
        return iskillhService.getSkillh();
    }
    
    @PostMapping("personas/skillh/crear")
    public String createSkill(@RequestBody Skillh skill){
        iskillhService.saveSkill(skill);
        return "Skill creada exitosamente";
    }
    
    @DeleteMapping("personas/skillh/borrar/{id}")
    public String deleteSkils(@PathVariable Long id){
        iskillhService.deleteSkill(id);
        return "Skill eliminada correctamente";
    }
    
    @PutMapping("personas/skillh/modificar/{id}")
    public String updateSkill(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("descripcion") String nuevaDescripcion,
                                @RequestParam("porcentaje") BigDecimal nuevoPorcentaje){
        Skillh skill = iskillhService.findSkill(id);
        skill.setNombre(nuevoNombre);
        skill.setDescripcion(nuevaDescripcion);
        skill.setPorcentaje(nuevoPorcentaje);
        
        iskillhService.saveSkill(skill);
        return "Skill modificada correctamente";
    }
}
