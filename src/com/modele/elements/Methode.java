package com.modele.elements;

import java.util.List;

/**
 *
 */
public class Methode
{
    /**
     * Attributs privés
     */
    private String nom, type;
    private String visibilite;
    private List<Attribut> parametres;

    /**
     * COnstructeur de Methode qui prend en paramètre les attributs nom, type, visibilite et prarametres
     * @param nom
     * @param type
     * @param visibilite
     * @param parametres
     */
    public Methode(String nom, String type, String visibilite, List<Attribut> parametres) {
        this.nom = nom;
        this.type = type;
        this.visibilite = visibilite;
        this.parametres = parametres;
    }

    /**
     * Methode getNom qui retourne l'attribut nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Methode setNom qui prend en paramètre l'attribut nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Methode getType qui retourne l'attribut type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Methode setType qui prend en paramètre l'attribut type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Methode getVisibilite qui retourne l'attribut visibilite
     * @return
     */
    public String getVisibilite() {
        return visibilite;
    }

    /**
     * Methode setVisibilite qui prend en paramètre l'attribut visibilite
     * @param visibilite
     */
    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    /**
     * Methode getParametres qui retourne l'attribut parametres
     * @return
     */
    public List<Attribut> getParametres() {
        return parametres;
    }

    /**
     * Methode setParametres qui prend en paramètres l'attribut parametres
     * @param parametres
     */
    public void setParametres(List<Attribut> parametres) {
        this.parametres = parametres;
    }

    /**
     * Methode modifier qui prend en paramètre les attributs visibilite, type, nom et parametres
     * @param visibilite
     * @param type
     * @param nom
     * @param parametres
     */
    public void modifier(String visibilite, String type, String nom, List<Attribut> parametres)
    {
        this.visibilite = visibilite;
        this.type = type;
        this.nom = nom;
        this.parametres = parametres;
    }


}
