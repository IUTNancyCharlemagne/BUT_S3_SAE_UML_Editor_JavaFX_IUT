package com.modele.elements;

import java.util.List;

public class Methode extends ElementVisibilite
{
    private String motCle;
    private List<Attribut> parametres;

    public Methode(String nom, String type, String visibilite, String motCle, List<Attribut> parametres) {
        super(nom, type, visibilite);
        this.motCle = motCle;
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


    public void modifier(String visibilite, String type, String nom, List<Attribut> parametres)
    {
        this.visibilite = visibilite;
        this.type = type;
        this.nom = nom;
        this.parametres = parametres;
    }

    public String getMotCle() {
        return motCle;
    }
}
