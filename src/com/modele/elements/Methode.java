package com.modele.elements;

import java.util.List;

public class Methode
{
    private String nom, type;
    private String visibilite;
    private List<Attribut> parametres;

    public Methode(String nom, String type, String visibilite, List<Attribut> parametres) {
        this.nom = nom;
        this.type = type;
        this.visibilite = visibilite;
        this.parametres = parametres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    public List<Attribut> getParametres() {
        return parametres;
    }

    public void setParametres(List<Attribut> parametres) {
        this.parametres = parametres;
    }
}
