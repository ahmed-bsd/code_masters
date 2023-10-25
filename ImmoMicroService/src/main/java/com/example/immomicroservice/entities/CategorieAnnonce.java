package com.example.immomicroservice.entities;

public enum CategorieAnnonce {
    MaisonAvendre("Maison A vendre"),
    MaisonALouer("Maison A Louer"),
    Villa("Villa"),
    Appartements("Appartements"),
    Terrain("Terrain ");
    private String CategorieName;

    CategorieAnnonce(String CategorieName ){this.CategorieName=CategorieName;}
    public String getName() {
        return CategorieName ;
    }

}
