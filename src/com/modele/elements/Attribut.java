package com.modele.elements;

public class Attribut implements Element
{
    private String nom, type;
    private char visibilite;

    public Attribut(ClasseInterface classe, String nom, String type, char visibilite) {
        this.nom = nom;
        this.type = type;
        this.visibilite = visibilite;
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

    public char getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(char visibilite) {
        this.visibilite = visibilite;
    }
}
