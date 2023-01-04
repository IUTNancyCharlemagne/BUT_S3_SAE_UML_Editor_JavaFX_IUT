package com.modele.elements;

import java.util.ArrayList;
import java.util.List;

public class ClasseInterface implements Element
{
    private String nom;
    private String visibilite;
    private List<Attribut> attributs;
    private List<Methode> methodes;
    private List<Association> associations;
    private Heritage heritage;
    private List<Implementation> implementation;

    public ClasseInterface(String nom, String visibilite) {
        this.nom = nom;
        this.visibilite = visibilite;
        this.attributs = new ArrayList<>();
        this.methodes = new ArrayList<>();
        this.associations = new ArrayList<>();
        this.implementation = new ArrayList<>();
        this.heritage = null;
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

    public List<Attribut> getAttributs() {
        return attributs;
    }

    public List<Methode> getMethodes() {
        return methodes;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public List<Implementation> getImplementations() {
        return implementation;
    }

    public Heritage getHeritage() {
        return heritage;
    }
}
