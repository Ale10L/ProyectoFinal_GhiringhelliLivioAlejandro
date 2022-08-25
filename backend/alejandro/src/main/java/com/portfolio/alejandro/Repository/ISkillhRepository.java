package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.Skillh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillhRepository extends JpaRepository<Skillh,Long>{
    
}
