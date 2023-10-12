package com.esprit.ms.microserviceproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAnnouncement;
    String description;
    String name;
    String localisation;
    double price;
    Boolean etat;
   @Enumerated(EnumType.STRING)
    CategorieAnnonce categorieAnnonce;
    String region;
    int likes;
    int dislikes;
    private  String image;
    //double score;
    int numEvaluations;
    @JsonIgnore
    @OneToMany(mappedBy = "annonce")
    List<Visit> visits;

}
