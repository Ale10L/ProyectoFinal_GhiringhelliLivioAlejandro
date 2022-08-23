package com.portfolio.alejandro.Controller;

import com.portfolio.alejandro.Entidades.Persona;
import com.portfolio.alejandro.Interfaces.IPersonaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @GetMapping("personas/traer-perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Persona creada exitosamente";
    }
    
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Persona eliminada correctamente";
    }
    
    @PutMapping("personas/modificar/{id}")
    public String updatePersona(@PathVariable Long id,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("fecha_nac") String nuevaFecha_Nac,
                                @RequestParam("acerca_de") String nuevoAcercaDe,
                                @RequestParam("imagen_perfil") String nuevaImagenPerfil,
                                @RequestParam("localidad") String nuevaLocalidad,
                                @RequestParam("email") String nuevoEmail,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam("enlace_linkedin") String nuevoEnlaceLinkedin,
                                @RequestParam("enlace_github") String nuevoEnlaceGithub,
                                @RequestParam("enlace_instagram") String nuevoEnlaceInstagram,
                                @RequestParam("enlace_whatsapp") String nuevoEnlaceWhatsapp) throws ParseException{
        Persona persona = ipersonaService.findPersona(id);
        persona.setApellido(nuevoApellido);
        persona.setNombre(nuevoNombre);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        persona.setFecha_nac(formato.parse(nuevaFecha_Nac));
        persona.setAcerca_de(nuevoAcercaDe);
        persona.setImagen_perfil(nuevaImagenPerfil);
        persona.setLocalidad(nuevaLocalidad);
        persona.setEmail(nuevoEmail);
        persona.setTitulo(nuevoTitulo);
        persona.setEnlace_linkedin(nuevoEnlaceLinkedin);
        persona.setEnlace_github(nuevoEnlaceGithub);
        persona.setEnlace_instagram(nuevoEnlaceInstagram);
        persona.setEnlace_whatsapp(nuevoEnlaceWhatsapp);
        
        ipersonaService.savePersona(persona);
        return "Persona modificada correctamente";
    }
}
