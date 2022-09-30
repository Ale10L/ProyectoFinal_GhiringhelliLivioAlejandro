package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.DTO.PersonaDTO;
import com.portfolio.alejandro.Entidades.Persona;
import com.portfolio.alejandro.Security.Controller.Mensaje;
import com.portfolio.alejandro.Services.ImpPersonaService;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personas")
@CrossOrigin(origins = "https://frontghiringhellialejandro.web.app/")
//@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired ImpPersonaService ipersonaService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> getPersona(){
        List<Persona> lista = ipersonaService.getPersona();
         return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @GetMapping("/traer-perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable Long id,
                                @RequestBody PersonaDTO dtopersona) throws ParseException{
        
        if(!ipersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = ipersonaService.getOne(id).get();
        persona.setAcerca_de(dtopersona.getAcerca_de());
        persona.setImagen_perfil(dtopersona.getImagen_perfil());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setEnlace_linkedin(dtopersona.getEnlace_linkedin());
        persona.setEnlace_github(dtopersona.getEnlace_github());
        persona.setEnlace_instagram(dtopersona.getEnlace_instagram());
        persona.setEnlace_whatsapp(dtopersona.getEnlace_whatsapp());
        return new ResponseEntity(new Mensaje("Información modificada correctamente"), HttpStatus.OK);
    }
}
