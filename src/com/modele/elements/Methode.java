package com.modele.elements;

import java.util.List;

public class Methode
{
    private ClasseInterface classe;
    private String nom, type;
    private char visibilite;
    private List<Attribut> parametres;

    public Methode(String nom, String type, char visibilite, List<Attribut> parametres) {
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

    public char getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(char visibilite) {
        this.visibilite = visibilite;
    }

    public List<Attribut> getParametres() {
        return parametres;
    }

    public void setParametres(List<Attribut> parametres) {
        this.parametres = parametres;
    }

    public ClasseInterface getClasse() {
        return classe;
    }

    public void setClasse(ClasseInterface classe) {
        this.classe = classe;
    }
}
