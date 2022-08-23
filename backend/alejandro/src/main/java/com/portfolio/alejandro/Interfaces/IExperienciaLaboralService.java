package com.portfolio.alejandro.Interfaces;

import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> getExperienciaLaboral();
    
    public void saveExperienciaLaboral(ExperienciaLaboral unaExperienciaLaboral);
    
    public void deleteExperienciaLaboral(Long id);
    
    public ExperienciaLaboral findExperienciaLaboral(Long id);
}
