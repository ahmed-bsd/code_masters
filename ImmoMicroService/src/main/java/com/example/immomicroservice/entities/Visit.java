package com.example.immomicroservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idvisit;
    Date visitDate;
    @ManyToOne
    Annonce annonce;
}
