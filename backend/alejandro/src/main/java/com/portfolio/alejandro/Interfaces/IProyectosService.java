package com.portfolio.alejandro.Interfaces;

import com.portfolio.alejandro.Entidades.Proyectos;
import java.util.List;

public interface IProyectosService {
    public List<Proyectos> getProyectos();
        
    public void saveProyecto(Proyectos unProyecto);
    
    public void deleteProyecto(Long id);
    
    public Proyectos findProyecto(Long id);
}
