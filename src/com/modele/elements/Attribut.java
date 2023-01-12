package com.modele.elements;

public class Attribut implements Element
{
    private String nom, type, visibilite, motCle;

    public Attribut(String nom, String type, String visibilite, String motCle) {
        this.nom = nom;
        this.type = type;
        this.visibilite = visibilite;
        this.motCle = motCle;
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

    public void modifier(String visibilite, String type, String nom) {
        this.visibilite = visibilite;
        this.type = type;
        this.nom = nom;
    }

    public String getMotCle() {
        return motCle;
    }
}
