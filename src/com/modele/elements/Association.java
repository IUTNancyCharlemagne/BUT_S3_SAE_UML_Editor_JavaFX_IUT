package com.modele.elements;

public class Association implements Element
{
    private ClasseInterface initClasse, destinationClasse;
    private String nom;
    private char visibilite;

    public Association(ClasseInterface i, ClasseInterface t, String n, char v)
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

    public char getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(char visibilite) {
        this.visibilite = visibilite;
    }
}
