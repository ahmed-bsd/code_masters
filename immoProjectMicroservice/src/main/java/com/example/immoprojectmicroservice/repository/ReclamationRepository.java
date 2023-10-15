package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.immoprojectmicroservice.entities.Reclamation;

import java.util.List;

///****    Developped by Ahmed bsd    ****////
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    List<Reclamation> findReclamationsByStatusIs(Reclamation.Status s);
    List<Reclamation> findReclamationsByStatusIsLike(Reclamation.Status s);

    //List<Reclamation> findReclamationsByUserAIs(Usea);

}
