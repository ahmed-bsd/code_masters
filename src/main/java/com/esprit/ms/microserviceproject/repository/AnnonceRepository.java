package com.esprit.ms.microserviceproject.repository;

import com.esprit.ms.microserviceproject.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository  extends JpaRepository<Annonce, Long> {
}
