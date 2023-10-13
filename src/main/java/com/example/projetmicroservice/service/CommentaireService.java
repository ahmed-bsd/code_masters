package com.example.projetmicroservice.service;


import com.example.projetmicroservice.entities.Commentaire;
import com.example.projetmicroservice.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;

    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }


    public List<Commentaire> getAllCommentaire() {
        return commentaireRepository.findAll();
    }

    public void deletetCommentaire(Long idCommentaire) {
        Commentaire commentaire= commentaireRepository.findById(idCommentaire).get();
        commentaireRepository.delete(commentaire);
    }

    public Commentaire findCommentaire(Long idCommentaire) {
        return commentaireRepository.findById(idCommentaire).get();
    }
}

