package com.modele.elements;

public class ElementVisibilite implements Element
{
    protected String nom, type, visibilite;

    public ElementVisibilite(String nom, String type, String visibilite) {
        this.nom = nom;
        this.visibilite = visibilite;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}