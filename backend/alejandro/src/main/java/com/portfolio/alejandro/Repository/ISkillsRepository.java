package com.portfolio.alejandro.Repository;

import com.portfolio.alejandro.Entidades.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills,Long>{
    
}
