package com.modele.elements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ClasseInterface implements Element
{
    /**
     * Attributs privés
     */
    private String nom;

    private String type;
    private List<Attribut> attributs;
    private List<Methode> methodes;
    private List<Association> associations;
    private Heritage heritage;
    private List<Implementation> implementation;
    private boolean selectionne, modification, isInterface;

    /**
     *
     * @param nom
     */
    public ClasseInterface(String nom) {
        String[] nomSplit = nom.split("\\.");
        this.nom = nomSplit[nomSplit.length-1];
        if (nom.contains("abstract interface")) {
            this.type = "interface";
        } else if (nom.contains("abstract class")) {
            this.type = "abstract class";
        } else {
            this.type = "classe";
        }
        this.attributs = new ArrayList<>();
        this.methodes = new ArrayList<>();
        this.associations = new ArrayList<>();
        this.implementation = new ArrayList<>();
        this.heritage = null;
    }

    /**
     * Methode getNom qui retourne l'attribut nom
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
     * Méthode getAttributs qui retourne l'attribut attributs
     * @return
     */
    public List<Attribut> getAttributs() {
        return attributs;
    }

    /**
     * Méthode getMethodes qui retourne l'attribut methodes
     * @return
     */
    public List<Methode> getMethodes() {
        return methodes;
    }

    /**
     * Méthode getAssociations qui retourne l'attribut associations
     * @return
     */
    public List<Association> getAssociations() {
        return associations;
    }

    /**
     * Methode getImplementations qui retourne l'attribut implementation
     * @return
     */
    public List<Implementation> getImplementations() {
        return implementation;
    }

    /**
     * Methode getHeritage qui retourne l'attribut heritage
     * @return
     */
    public Heritage getHeritage() {
        return heritage;
    }

    /**
     * Methode ajouterAttribut qui prend en paramètre l'attribut attributs et qui permet d'ajouter un attribut
     * @param attributs
     */
    public void ajouterAttribut(String attributs) {
        try{
            System.out.println("Attribut: " + attributs);
            String[] attributSplit = attributs.split("\\n");
            for (String attribut : attributSplit) {

                String accessibilite = this.determinerAccessibilite(attribut);
                String type = attribut.split(" ")[1];
                String nom = attribut.split(" ")[2];
                this.attributs.add(new Attribut(nom, type, accessibilite));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'attribut " + attributs);
        }
    }

    /**
     * Methode ajouterMethode qui prend en paramètre l'attribut methodes et qui permet d'ajouter une methode
     * @param methodes
     */
    public void ajouterMethode(String methodes) {
        try {
            String[] methodesTab = methodes.split("\\n");
            for (String methode : methodesTab) {
                String accessibilite = determinerAccessibilite(methode);
                String type = methode.split(" ")[1];
                String nom = methode.split(" ")[2].split("\\(")[0];
                List<Attribut> attributs = determinerAttributs(methode);
                this.methodes.add(new Methode(nom, type, accessibilite,attributs));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la methode " + methodes);
        }
    }

    /**
     * Methode ajouterConstructeur qui prend en paramètre l'attribut methodes et qui permet d'ajouter une methode
     * @param methodes
     */
    public void ajouterConstructeur(String methodes) {
        try {
            String[] methodesTab = methodes.split("\\n");
            for (String methode : methodesTab) {
                System.out.println(methode);
                String accessibilite = determinerAccessibilite(methode);
                String nom = methode.split(" ")[1].split("\\(")[0];
                List<Attribut> attributs = determinerAttributs(methode);
                this.methodes.add(new Methode(nom, "", accessibilite,attributs));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du constructeur " + methodes);
        }
    }

    /**
     * Methode determinerAttributs qui prend en paramètre l'attribut methode et qui permet de retourner une liste d'attributs
     * @param methode
     * @return
     */
    private List<Attribut> determinerAttributs(String methode) {
        String[] parametres = methode.split("\\(")[1].replace(")", "").split(",");
        List<Attribut> parametresList = new ArrayList<>();
        for (String parametre : parametres) {
            Attribut attribut = new Attribut("", parametre, "");
            parametresList.add(attribut);
        }
        return parametresList;
    }

    /**
     * Methode determinerAccessibilite qui prend en paramètre l'attribut element et qui permet de retourner l'accessibilité d'un élément
     * @param element
     * @return
     */
    private String determinerAccessibilite(String element){
        if (element.contains("public")){
            return "public";
        } else if (element.contains("private")){
            return "private";
        } else if (element.contains("protected")){
            return "protected";
        } else {
            return "public";
        }
    }

    /**
     * Methode ajouterAssociation qui prend en paramètre l'attribut association et qui permet d'ajouter une association
     * @param association
     */
    public void ajouterAssociation(Association association) {
        this.associations.add(association);
    }

    /**
     * Methode ajouterImplementation qui prend en paramètre l'attribut implementation et qui permet d'ajouter une implementation
     * @param implementation
     */
    public void ajouterImplementation(String implementation) {
        //this.implementation.add(implementation);
    }

    /**
     * Methode ajouterHeritage qui prend en paramètre l'attribut heritage
     * @param heritage
     */
    public void ajouterHeritage(String heritage) {
        //this.heritage = heritage;
    }

    /**
     * Methode isInterface qui retourne l'attribut isInterface
     * @return
     */
    public boolean isInterface() {
        return isInterface;
    }

    /**
     * Methode setInterface qui prend en paramètre l'attribut isInterface
     * @param isInterface
     */
    public void setInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }

    /**
     * Methode modifierAttribut qui permet de modifier un attribut
     * @param attribut
     * @param visibilite
     * @param type
     * @param nom
     */
    public void modifierAttribut(Attribut attribut, String visibilite, String type, String nom)
    {
        attribut.modifier(visibilite, type, nom);
    }

    /**
     * Methode modifierMethode qui permet de modifier une methode
     * @param methode
     * @param visibilite
     * @param type
     * @param nom
     * @param parametres
     */
    public void modifierMethode(Methode methode, String visibilite, String type, String nom, List<Attribut> parametres)
    {
        methode.modifier(visibilite, type, nom, parametres);
    }

    /**
     * Methode modifierHeritage qui permet de modifier un heritage à partir de l'attribut heritage
     * @param heritage
     * @param initClasse
     * @param destinationClasse
     */
    public void modifierHeritage(Heritage heritage, ClasseInterface initClasse, ClasseInterface destinationClasse)
    {
        heritage.modifier(initClasse, destinationClasse);
    }

    /**
     * Methode modifierHeritage qui permet de modifier un heritage à partir de l'attribut implementation
     * @param implementation
     * @param initClasse
     * @param destinationClasse
     */
    public void modifierHeritage(Implementation implementation, ClasseInterface initClasse, ClasseInterface destinationClasse)
    {
        implementation.modifier(initClasse, destinationClasse);
    }

    /**
     * Methode modifierAssociation qui permet de modifier une association
     * @param association
     * @param visibilite
     * @param nom
     * @param initClasse
     * @param destinationClasse
     */
    public void modifierAssociation(Association association, String visibilite, String nom, ClasseInterface initClasse, ClasseInterface destinationClasse)
    {
        association.modifier(visibilite, nom, initClasse, destinationClasse);
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
     * Methode modifier qui prend en paramètre les attributs nom et type
     * @param nom
     * @param type
     */
    public void modifier(String nom, String type)
    {
        this.nom = nom;
        this.type = type;
    }
}
