package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos,Long>{
    
}
