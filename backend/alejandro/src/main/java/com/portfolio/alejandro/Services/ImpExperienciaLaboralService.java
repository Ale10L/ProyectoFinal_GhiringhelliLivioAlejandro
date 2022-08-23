package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import com.portfolio.alejandro.Interfaces.IExperienciaLaboralService;
import com.portfolio.alejandro.Repository.IExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired IExperienciaLaboralRepository iexperienciaRepository;
    
    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral() {
        List<ExperienciaLaboral> Persona = iexperienciaRepository.findAll();
        return Persona;
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral unaPersona) {
        iexperienciaRepository.save(unaPersona);
    }

    @Override
    public void deleteExperienciaLaboral(Long id) {
        iexperienciaRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        ExperienciaLaboral Persona = iexperienciaRepository.findById(id).orElse(null);
        return Persona;
    }
}
