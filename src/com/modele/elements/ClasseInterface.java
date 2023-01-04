package com.modele.elements;

import java.util.ArrayList;
import java.util.List;

public class ClasseInterface implements Element
{
    private String nom;
    private char visibilite;

    private List<Attribut> attributs;
    private List<Methode> methodes;

    public ClasseInterface(String nom, char visibilite) {
        this.nom = nom;
        this.visibilite = visibilite;
        this.attributs = new ArrayList<>();
        this.methodes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(char visibilite) {
        this.visibilite = visibilite;
    }
}
