package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.Skillh;
import com.portfolio.alejandro.Interfaces.ISkillhService;
import com.portfolio.alejandro.Repository.ISkillhRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSkillhService implements ISkillhService{
    @Autowired ISkillhRepository iskillhRepository;

    @Override
    public List<Skillh> getSkillh() {
        return iskillhRepository.findAll();
    }

    @Override
    public void saveSkill(Skillh unaSkill) {
        iskillhRepository.save(unaSkill);
    }

    @Override
    public void deleteSkill(Long id) {
        iskillhRepository.deleteById(id);
    }

    @Override
    public Skillh findSkill(Long id) {
        Skillh Skill = iskillhRepository.findById(id).orElse(null);
        return Skill;
    }
    
    public Optional<Skillh> getOne(Long id){
        return iskillhRepository.findById(id);
    }
    
    public Optional<Skillh> getByNombre(String nombre){
        return iskillhRepository.findByNombre(nombre);
    }
    
    public boolean existsById(Long id){
        return iskillhRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iskillhRepository.existsByNombre(nombre);
    }
}
