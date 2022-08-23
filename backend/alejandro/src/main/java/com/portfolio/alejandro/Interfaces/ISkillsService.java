package com.portfolio.alejandro.Interfaces;

import com.portfolio.alejandro.Entidades.Skills;
import java.util.List;

public interface ISkillsService {
    public List<Skills> getSkills();
        
    public void saveSkill(Skills unaSkill);
    
    public void deleteSkill(Long id);
    
    public Skills findSkill(Long id);
}
