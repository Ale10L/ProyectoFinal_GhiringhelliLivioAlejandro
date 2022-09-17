package com.portfolio.alejandro.Interfaces;

import com.portfolio.alejandro.Entidades.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersona();    
    
    public Persona findPersona();
    
    public void savePersona(Persona unaPersona);    
    
    public void deletePersona(Long id);    
    
    public Persona findPersona(Long id);
}
