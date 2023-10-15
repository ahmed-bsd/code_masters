package com.example.immoprojectmicroservice.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Announce implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAnnouncement;
    CategorieAnnouncement categorieAnnouncement;

    String description;

    //****  added by bsd dev  ****//
    @Column(columnDefinition = "TEXT")
    private String schools;
    @Column(columnDefinition = "TEXT")
    private String restaurants;
    @Column(columnDefinition = "TEXT")
    private String hospitals;
    @Column(columnDefinition = "TEXT")
    private String pharmacies ;
/*
    @JsonIgnore
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserA seller;
*/
    @JsonManagedReference(value="view-announcement")
    @OneToMany(mappedBy = "announcement")
    private List<AnnouncementViewer> viewers = new ArrayList<>();

    @OneToMany(mappedBy = "announcement")
    List<SponsoringPlan> sponsoringPlans;

    private Boolean sponsored;

    private Double sponsoringWeight;

    private Float rating;

    //**** finish add ****//





}
