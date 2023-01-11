package com.modele.elements;

/**
 *
 */
public class Attribut implements Element
{
    /**
     * Attributs privés
     */
    private String nom, type, visibilite;

    /**
     * Constructeur d'Attribut qui prend en paramètre les attributs nom, type et visibilite
     * @param nom
     * @param type
     * @param visibilite
     */
    public Attribut(String nom, String type, String visibilite) {
        this.nom = nom;
        this.type = type;
        this.visibilite = visibilite;
    }

    /**
     * Méthode getNom qui retorune l'attribut nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode setNom qui prend en paramètre l'attribut nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode getType qui retourne l'attribut type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Méthode setType qui prend en paramètre l'attribut type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Méthode getVisibilite qui retourne l'attribut visibilite
     * @return
     */
    public String getVisibilite() {
        return visibilite;
    }

    /**
     * Méthode setVisibilite qui prend en paramètre l'attribut visibilite
     * @param visibilite
     */
    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    /**
     * Méthode modifier qui permet de modifier un attribut
     * @param visibilite
     * @param type
     * @param nom
     */
    public void modifier(String visibilite, String type, String nom) {
        this.visibilite = visibilite;
        this.type = type;
        this.nom = nom;
    }
}
