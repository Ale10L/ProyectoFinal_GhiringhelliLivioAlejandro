package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.Persona;
import com.portfolio.alejandro.Interfaces.IPersonaService;
import com.portfolio.alejandro.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> Persona = ipersonaRepository.findAll();
        return Persona;
    }

    @Override
    public void savePersona(Persona unaPersona) {
        ipersonaRepository.save(unaPersona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona Persona = ipersonaRepository.findById(id).orElse(null);
        return Persona;
    }

    @Override
    public Persona findPersona() {
        Persona Persona = ipersonaRepository.findById((long)1).orElse(null);
        return Persona;
    }
    
    public Optional<Persona> getOne(Long id){
        return ipersonaRepository.findById(id);
    }
    
    public boolean existsById(Long id){
        return ipersonaRepository.existsById(id);
    }
}
