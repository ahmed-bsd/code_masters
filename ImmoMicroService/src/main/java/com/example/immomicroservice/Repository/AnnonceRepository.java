package com.example.immomicroservice.Repository;

import com.example.immomicroservice.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository  extends JpaRepository<Annonce, Long> {
}
