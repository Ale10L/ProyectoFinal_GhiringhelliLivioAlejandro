package com.portfolio.alejandro.Interfaces;

import com.portfolio.alejandro.Entidades.Skillh;
import java.util.List;

public interface ISkillhService {
    public List<Skillh> getSkillh();
        
    public void saveSkill(Skillh unaSkill);
    
    public void deleteSkill(Long id);
    
    public Skillh findSkill(Long id);
}
