package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.Skills;
import com.portfolio.alejandro.Interfaces.ISkillsService;
import com.portfolio.alejandro.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSkillsService implements ISkillsService{
    @Autowired ISkillsRepository iskillsRepository;

    @Override
    public List<Skills> getSkills() {
        return iskillsRepository.findAll();
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
    
    public Optional<Skills> getOne(Long id){
        return iskillsRepository.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre){
        return iskillsRepository.findByNombre(nombre);
    }
    
    public boolean existsById(Long id){
        return iskillsRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iskillsRepository.existsByNombre(nombre);
    }
}
