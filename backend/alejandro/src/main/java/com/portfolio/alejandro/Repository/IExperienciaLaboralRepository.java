package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral,Long>{
    
}
