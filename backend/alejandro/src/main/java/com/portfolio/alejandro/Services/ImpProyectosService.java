package com.portfolio.alejandro.Services;

import com.portfolio.alejandro.Entidades.Proyectos;
import com.portfolio.alejandro.Interfaces.IProyectosService;
import com.portfolio.alejandro.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyectosService implements IProyectosService{
    @Autowired IProyectosRepository iproyectosRepository;
    
    @Override
    public List<Proyectos> getProyectos() {
        return iproyectosRepository.findAll();
    }

    @Override
    public void saveProyecto(Proyectos unProyecto) {
        iproyectosRepository.save(unProyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        iproyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos findProyecto(Long id) {
        Proyectos Proyecto = iproyectosRepository.findById(id).orElse(null);
        return Proyecto;
    }
    
    public Optional<Proyectos> getOne(Long id){
        return iproyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return iproyectosRepository.findByNombre(nombre);
    }
    
    public boolean existsById(Long id){
        return iproyectosRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iproyectosRepository.existsByNombre(nombre);
    }
}
