package com.modele.elements;

import java.util.ArrayList;
import java.util.List;

public class ClasseInterface implements Element
{
    private String nom;
    private List<Attribut> attributs;
    private List<Methode> methodes;
    private List<Association> associations;
    private Heritage heritage;
    private List<Implementation> implementation;

    public ClasseInterface(String nom) {
        this.nom = nom;
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
        try {
            String accessibilite;
            if (!attribut.contains("public") && !attribut.contains("private") && !attribut.contains("protected")) {
                accessibilite = "public";
            }
            else {
                accessibilite = attribut.split(" ")[0];
            }
            String type = attribut.split(" ")[1];
            String nom = attribut.split(" ")[2];
            this.attributs.add(new Attribut(nom, type, accessibilite));
        }catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'attribut " + attribut);
        }

    }

    public void ajouterMethode(String methode) {
        try {
            String accessibilite = methode.split(" ")[0];
            String type = methode.split(" ")[1];
            String nom = methode.split(" ")[2];
            List<Attribut> parametres = new ArrayList<>();
            String attributs = methode.split("\\(")[1].split("\\)")[0];
            if (!attributs.equals("")) {
                for (String attribut : attributs.split(",")) {
                    String typeParametre = attribut.split(" ")[0];
                    parametres.add(new Attribut("", typeParametre, ""));
                }
            }
            this.methodes.add(new Methode(nom, type, accessibilite,parametres));
        }catch (Exception e){
            System.out.println("Erreur lors de l'ajout de la methode " + methode);
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
