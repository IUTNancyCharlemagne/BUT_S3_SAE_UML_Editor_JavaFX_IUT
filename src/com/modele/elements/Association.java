package com.modele.elements;

public class Association implements Element
{
    private ClasseInterface initClasse, destinationClasse;
    private String nom;
    private String visibilite;

    public Association(ClasseInterface i, ClasseInterface t, String n, String v)
    {
        this.initClasse = i;
        this.destinationClasse = t;
        this.nom = n;
        this.visibilite = v;
    }

    public ClasseInterface getInitClasse() {
        return initClasse;
    }

    public void setInitClasse(ClasseInterface initClasse) {
        this.initClasse = initClasse;
    }

    public ClasseInterface getDestination() {
        return destinationClasse;
    }

    public void setDestination(ClasseInterface destination) {
        this.destinationClasse = destination;
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

    public void modifier(String visibilite, String nom, ClasseInterface initClasse, ClasseInterface destinationClasse) {
        this.initClasse = initClasse;
        this.destinationClasse = destinationClasse;
        this.nom = nom;
        this.visibilite = visibilite;
    }
}
