package com.modele.elements;

import java.util.ArrayList;
import java.util.List;

public class ClasseInterface implements Element
{
    private String nom;

    private String type;
    private List<Attribut> attributs;
    private List<Methode> methodes;
    private List<Association> associations;
    private Heritage heritage;
    private List<Implementation> implementation;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void ajouterAttribut(String attribut) {
        try{
            if (attribut.length() > 1) {
                String accessibilite = this.determinerAccessibilite(attribut);
                String type = attribut.split(" ")[1];
                String nom = attribut.split(" ")[2];
                this.attributs.add(new Attribut(nom, type, accessibilite));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'attribut " + attribut);
        }
    }

    public void ajouterMethode(String methode) {
        try {
            if (methode.length() > 1) {
                String accessibilite = this.determinerAccessibilite(methode);
                String type = methode.split(" ")[1];
                String nom = methode.split(" ")[2];
                List<Attribut> parametres = new ArrayList<>();
                String attributs = methode.split("\\(")[1].split("\\)")[0];
                this.methodes.add(new Methode(nom, type, accessibilite, parametres));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la méthode " + methode);
        }
    }

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

    public void ajouterAssociation(Association association) {
        this.associations.add(association);
    }

    public void ajouterImplementation(String implementation) {
        //this.implementation.add(implementation);
    }

    public void ajouterHeritage(String heritage) {
        //this.heritage = heritage;
    }
}
