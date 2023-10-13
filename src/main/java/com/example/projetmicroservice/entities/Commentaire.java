package com.example.projetmicroservice.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Commentaire implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommentaire;

    String contenuCom;

    @Temporal(TemporalType.TIMESTAMP)
    Date dateCom;

    @ManyToOne
    @JoinColumn(name = "idPost") // Clé étrangère vers l'entité Post
    Post post;

    // Constructeurs, getters, setters, etc.
}
