package com.esprit.ms.microserviceproject.service;


import com.esprit.ms.microserviceproject.entities.Annonce;
import com.esprit.ms.microserviceproject.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository annonceRepository;

    
    public Annonce addAnnouncement(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public List<Annonce> getAllAnnouncement() {
        return annonceRepository.findAll();
    }

    public void deletetAnnouncement(Long id) {
        Annonce announcement = annonceRepository.findById(id).get();
        annonceRepository.delete(announcement);

    }


    public Annonce findAnnouncement(Long id) {
        return annonceRepository.findById(id).get();
    }
    //Recherche multicritére
    @Autowired
    private EntityManager entityManager;
    public List<Annonce> findbyCriteria(Annonce announcement) {
        String querry = "SELECT a FROM Annonce as a WHERE 1=1 ";
        if (announcement.getName() != null && !announcement.getName().isEmpty())
            querry += "AND a.name='" + announcement.getName() + "'";
        if (announcement.getDescription() != null && !announcement.getDescription().isEmpty())
            querry += "AND a.description='" + announcement.getDescription() + "'";
        if (announcement.getEtat() != null && !announcement.getEtat().booleanValue())
            querry += "AND a.etat='" + announcement.getEtat() + "'";

        return entityManager.createQuery(querry).getResultList();

    }
    //like announcement

    public ResponseEntity<Void> likePost(Long id) {
        //creation d'une liste d'annoucement geti feha par id les annoucement
        Optional<Annonce> optionalAnnouncement = annonceRepository.findById(id);
        // is persent() :Return true if there is a value present, otherwise false.
        if (optionalAnnouncement.isPresent()) {
            Annonce announcement = optionalAnnouncement.get();
            int likes = announcement.getLikes();
            //increments its likes count by 1
            announcement.setLikes(likes + 1);
            annonceRepository.save(announcement);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //dislike announcement

    public ResponseEntity<Void> dislikePost(Long id) {
        //creation d'une liste d'annoucement geti feha par id les annoucement
        Optional<Annonce> optionalAnnouncement = annonceRepository.findById(id);
        // is persent() :Return true if there is a value present, otherwise false.
        if (optionalAnnouncement.isPresent()) {
            Annonce announcement = optionalAnnouncement.get();

            int dislikes = announcement.getDislikes();
            //increments its dislikes count by 1
            announcement.setDislikes(dislikes + 1);

            annonceRepository.save(announcement);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
