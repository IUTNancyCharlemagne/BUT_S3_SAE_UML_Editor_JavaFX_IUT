package com.modele.elements;

public class Attribut extends ElementVisibilite implements Element
{
    private String motCle;

    public Attribut(String nom, String type, String visibilite) {
        super(nom, type, visibilite);
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
