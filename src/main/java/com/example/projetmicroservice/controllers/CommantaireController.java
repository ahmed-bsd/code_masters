package com.example.projetmicroservice.controllers;


import com.example.projetmicroservice.entities.Commentaire;
import com.example.projetmicroservice.service.CommentaireService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "commentaire")
@RequestMapping("/commentaire")
public class CommantaireController {
    @Autowired
    CommentaireService commentaireService;
    @PostMapping("/add")
    @ResponseBody
    public Commentaire ajouterCommentaire(@RequestBody Commentaire commentaire) {

        return commentaireService.createCommentaire(commentaire);
    }
    @GetMapping("/all/commentaire")
    @ResponseBody
    public List<Commentaire> getcommentaire(){
        return  commentaireService.getAllCommentaire();
    }


    @DeleteMapping("/delete/commentaire/{id}")
    public void deleteComm(@PathVariable("id") Long idCommentaire) {
        commentaireService.deletetCommentaire(idCommentaire);
    }
    @GetMapping("/find/comm/{id}")
    public Commentaire findCommentaire(@PathVariable("id") Long idCommentaire) {
        return commentaireService.findCommentaire(idCommentaire);
    }


}
