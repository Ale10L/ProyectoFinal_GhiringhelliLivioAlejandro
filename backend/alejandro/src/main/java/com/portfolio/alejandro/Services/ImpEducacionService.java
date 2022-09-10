package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Repository.IEducacionRepository;
import com.portfolio.alejandro.Entidades.Educacion;
import com.portfolio.alejandro.Interfaces.IEducacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEducacionService implements IEducacionService{
    @Autowired IEducacionRepository ieducacionRepository;
    
    @Override
    public List<Educacion> getEducacion() {
        return ieducacionRepository.findAll();
    }

    @Override
    public void saveEducacion(Educacion unaEducacion) {
        ieducacionRepository.save(unaEducacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        ieducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion Educacion = ieducacionRepository.findById(id).orElse(null);
        return Educacion;
    }
    
    public Optional<Educacion> getOne(Long id){
        return ieducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombre(String nombre){
        return ieducacionRepository.findByNombre(nombre);
    }
    
    public boolean existsById(Long id){
        return ieducacionRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ieducacionRepository.existsByNombre(nombre);
    }
}
