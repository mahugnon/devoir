package org.issatso.mspi.repository;

import org.issatso.mspi.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuteurRepository extends JpaRepository<Auteur, String> {
    @Query("select a from Auteur a where a.email like :x")
public  Auteur findAuteur(@Param("x") String email);
}
