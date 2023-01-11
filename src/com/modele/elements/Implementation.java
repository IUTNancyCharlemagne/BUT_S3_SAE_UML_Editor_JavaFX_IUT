package com.modele.elements;

/**
 *
 */
public class Implementation
{
    /**
     * Attributs privés
     */
    private ClasseInterface initClasse, destinationClasse;

    /**
     * Constructeur de Implementationqui prend en paramètre les attributs initClasse et destinationClasse
     * @param initClasse
     * @param destinationClasse
     */
    public Implementation(ClasseInterface initClasse, ClasseInterface destinationClasse) {
        this.initClasse = initClasse;
        this.destinationClasse = destinationClasse;
    }

    /**
     * Methode getInitClasse qui retourne l'attribut initClasse
     * @return
     */
    public ClasseInterface getInitClasse() {
        return initClasse;
    }

    /**
     * Methode SetInitClasse qui prend en paramètre l'attribut initClasse
     * @param initClasse
     */
    public void setInitClasse(ClasseInterface initClasse) {
        this.initClasse = initClasse;
    }

    /**
     * Methode getDestinationClasse qui retourne l'attribut destinationClasse
     * @return
     */
    public ClasseInterface getDestinationClasse() {
        return destinationClasse;
    }

    /**
     * Methode setDestinationClasse qui prend en paramètre l'attribut destinationClasse
     * @param destinationClasse
     */
    public void setDestinationClasse(ClasseInterface destinationClasse) {
        this.destinationClasse = destinationClasse;
    }

    /**
     * Methode modifier qui prend en paramètre les attributs initClasse et destinationClasse
     * @param initClasse
     * @param destinationClasse
     */
    public void modifier(ClasseInterface initClasse, ClasseInterface destinationClasse) {
        this.initClasse = initClasse;
        this.destinationClasse = destinationClasse;
    }
}
