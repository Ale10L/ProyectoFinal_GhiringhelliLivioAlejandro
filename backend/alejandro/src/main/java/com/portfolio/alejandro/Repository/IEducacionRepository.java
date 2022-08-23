package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Long>{
    
}
