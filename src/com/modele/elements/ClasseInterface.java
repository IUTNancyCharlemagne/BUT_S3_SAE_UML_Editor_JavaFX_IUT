package com.modele.elements;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void ajouterMethode(String methodes) {
        try {
            String[] methodesTab = methodes.split("\\n");
            for (String methode : methodesTab) {
                String[] methodeSplit = methode.split(" ");
                String accessibilite = methodeSplit[0];
                String type = methodeSplit[1];
                methodeSplit = methodeSplit[2].split("\\(");
                String nom = methodeSplit[0];
                String[] parametres = methodeSplit[1].replace(")", "").split(",");
                List<Attribut> parametresList = new ArrayList<>();
                for (String parametre : parametres) {
                    Attribut attribut = new Attribut("", parametre, "");
                    parametresList.add(attribut);
                }
                this.methodes.add(new Methode(nom, type, accessibilite, parametresList));
            }
        }catch (Exception e){
            System.out.println("Erreur lors de l'ajout de la methode " + methodes);
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
