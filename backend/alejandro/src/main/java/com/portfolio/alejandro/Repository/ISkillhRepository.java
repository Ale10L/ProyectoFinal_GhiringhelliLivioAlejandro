package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.Skillh;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillhRepository extends JpaRepository<Skillh,Long>{
    public Optional<Skillh> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
