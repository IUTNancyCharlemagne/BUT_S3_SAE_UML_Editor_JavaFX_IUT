package com.modele.elements;

public class Implementation
{
    private ClasseInterface initClasse, destinationClasse;

    public Implementation(ClasseInterface initClasse, ClasseInterface destinationClasse) {
        this.initClasse = initClasse;
        this.destinationClasse = destinationClasse;
    }

    public ClasseInterface getInitClasse() {
        return initClasse;
    }

    public void setInitClasse(ClasseInterface initClasse) {
        this.initClasse = initClasse;
    }

    public ClasseInterface getDestinationClasse() {
        return destinationClasse;
    }

    public void setDestinationClasse(ClasseInterface destinationClasse) {
        this.destinationClasse = destinationClasse;
    }

    public void modifier(ClasseInterface initClasse, ClasseInterface destinationClasse) {
        this.initClasse = initClasse;
        this.destinationClasse = destinationClasse;
    }
}
