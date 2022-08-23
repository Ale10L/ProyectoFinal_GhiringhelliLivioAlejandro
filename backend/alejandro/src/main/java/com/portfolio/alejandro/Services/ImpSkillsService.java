package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.Skills;
import com.portfolio.alejandro.Interfaces.ISkillsService;
import com.portfolio.alejandro.Repository.ISkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSkillsService implements ISkillsService{
    @Autowired ISkillsRepository iskillsRepository;

    @Override
    public List<Skills> getSkills() {
        List<Skills> Skill = iskillsRepository.findAll();
        return Skill;
    }

    @Override
    public void saveSkill(Skills unaSkill) {
        iskillsRepository.save(unaSkill);
    }

    @Override
    public void deleteSkill(Long id) {
        iskillsRepository.deleteById(id);
    }

    @Override
    public Skills findSkill(Long id) {
        Skills Skill = iskillsRepository.findById(id).orElse(null);
        return Skill;
    }
    
}
