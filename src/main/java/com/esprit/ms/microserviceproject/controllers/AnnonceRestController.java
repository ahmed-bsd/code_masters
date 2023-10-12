package com.esprit.ms.microserviceproject.controllers;


import com.esprit.ms.microserviceproject.entities.Annonce;
import com.esprit.ms.microserviceproject.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("annonce")
@RestController
public class AnnonceRestController {

    @Autowired
    AnnonceService annonceService;

    private String title="hello Farahhhhhhhh !!!!!!!!!";
    @RequestMapping("/hello")
    public String sayhello(){
        System.out.println(title);
        return title;
    }
    //ajout des annonces
    @PostMapping("/add/annonce")
    @ResponseBody
    public Annonce addAnnouncement(@RequestBody Annonce announcement) {
        Annonce a= annonceService.addAnnouncement(announcement);
        return a;
    }

    @GetMapping("/all/annonce")
    @ResponseBody
    public List<Annonce> getAnnouncement(){
        return  annonceService.getAllAnnouncement();
    }

    @DeleteMapping("/delete/annonce/{id}")
    public void deleteAnnonce(@PathVariable("id") Long id) {
        annonceService.deletetAnnouncement(id);
    }
    @GetMapping("/find/annonce/{id}")
    public Annonce findAnnonce(@PathVariable("id") Long id) {
       return annonceService.findAnnouncement(id);
    }
    //Recherche multicritére
    @PostMapping("/criteria")
    public List<Annonce> findByCriteria(@RequestBody Annonce announcement){
        return annonceService.findbyCriteria(announcement);
    }
    //like announcement
    @PostMapping("like/{id}")
    public ResponseEntity<Void> likePost(@PathVariable Long id) {
        return  annonceService.likePost(id);

    }
    //dislike announcement
    @PostMapping("dislike/{id}")
    public ResponseEntity<Void> dislikePost(@PathVariable Long id) {
        return  annonceService.dislikePost(id);

    }


}
