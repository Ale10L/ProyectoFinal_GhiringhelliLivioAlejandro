package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import com.portfolio.alejandro.Interfaces.IExperienciaLaboralService;
import com.portfolio.alejandro.Repository.IExperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired IExperienciaLaboralRepository iexperienciaRepository;
    
    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral() {
        return iexperienciaRepository.findAll();
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral unaExperienciaLaboral) {
        iexperienciaRepository.save(unaExperienciaLaboral);
    }

    @Override
    public void deleteExperienciaLaboral(Long id) {
        iexperienciaRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        ExperienciaLaboral experienciaLaboral = iexperienciaRepository.findById(id).orElse(null);
        return experienciaLaboral;
    }
    
    public Optional<ExperienciaLaboral> getOne(Long id){
        return iexperienciaRepository.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByNombre(String nombre){
        return iexperienciaRepository.findByNombre(nombre);
    }
    
    public boolean existsById(Long id){
        return iexperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iexperienciaRepository.existsByNombre(nombre);
    }
}
