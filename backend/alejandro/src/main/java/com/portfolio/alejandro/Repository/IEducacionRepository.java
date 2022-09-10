package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Long>{
    public Optional<Educacion> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
