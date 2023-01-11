package com.modele.elements;

/**
 *
 */
public class Association implements Element
{
    /**
     * attributs privés
     */
    private ClasseInterface initClasse, destinationClasse;
    private String nom;
    private String visibilite;

    /**
     * Constructeur de Association qui prend en paramètre les attributs i, t, n et v
     * @param i
     * @param t
     * @param n
     * @param v
     */
    public Association(ClasseInterface i, ClasseInterface t, String n, String v)
    {
        this.initClasse = i;
        this.destinationClasse = t;
        this.nom = n;
        this.visibilite = v;
    }

    /**
     * Méthode getInitClasse qui permet de retourner l'attribut initCLasse
     * @return
     */
    public ClasseInterface getInitClasse() {
        return initClasse;
    }

    /**
     * Méthode setInitClasse qui prend en paramètre l'attribut initClasse
     * @param initClasse
     */
    public void setInitClasse(ClasseInterface initClasse) {
        this.initClasse = initClasse;
    }

    /**
     * Méthode getDestination qui permet de retourner l'attribut destinationClasse
     * @return
     */
    public ClasseInterface getDestination() {
        return destinationClasse;
    }

    /**
     * Méthode setDestination qui prend en paramètre l'attribut destination
     * @param destination
     */
    public void setDestination(ClasseInterface destination) {
        this.destinationClasse = destination;
    }

    /**
     * Méthode getNom qui permet de retourner l'attribut nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode setNom qui prend en parametre l'attribut nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode getVisibilite qui permet de retourner l'attribut visibilite
     * @return
     */
    public String getVisibilite() {
        return visibilite;
    }

    /**
     * Méthode setVisibilite qui prend en parametre l'attribut visibilite
     * @param visibilite
     */
    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    /**
     * Méthode modifier qui permet de modifier une association
     * @param visibilite
     * @param nom
     * @param initClasse
     * @param destinationClasse
     */
    public void modifier(String visibilite, String nom, ClasseInterface initClasse, ClasseInterface destinationClasse) {
        this.initClasse = initClasse;
        this.destinationClasse = destinationClasse;
        this.nom = nom;
        this.visibilite = visibilite;
    }
}
