package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral,Long>{
    public Optional<ExperienciaLaboral> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
