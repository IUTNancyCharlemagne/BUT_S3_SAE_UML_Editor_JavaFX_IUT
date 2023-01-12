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
    private boolean selectionne, modification, isInterface;

    public ClasseInterface(String nom) {
        String[] nomSplit = nom.split("\\.");
        this.nom = nomSplit[nomSplit.length-1];
        if (nom.contains("abstract interface")) {
            this.type = "interface";
        } else if (nom.contains("abstract class")) {
            this.type = "abstract class";
        } else if (nom.contains("class")) {
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

    public void ajouterAttribut(String attributs) {

            String[] attributSplit = attributs.split("\\n");
            for (String attribut : attributSplit) {
                try {
                    String accessibilite = this.determinerAccessibilite(attribut);
                    String motCle = determinerMotCle(attribut);
                    String[] temp = attribut.split(" ");
                    String type = temp[temp.length - 2];
                    String nom = temp[temp.length - 1];
                    System.out.println(nom);
                    this.attributs.add(new Attribut(nom, type, accessibilite, motCle));
                }catch (Exception e) {
                    System.out.println("Erreur lors de l'ajout de l'attribut " + attribut);
                }
            }
        }

    public void ajouterMethode(String methodes) {
        try {
            String[] methodesTab = methodes.split("\\n");
            for (String methode : methodesTab) {
                String accessibilite = determinerAccessibilite(methode);
                String motCle = determinerMotCle(methode);

                String[] temp = methode.split("\\(");
                temp = temp[0].split(" ");
                String type = temp[temp.length-2];
                String nom = temp[temp.length-1].split("\\(")[0];

                List<Attribut> attributs = determinerAttributs(methode);
                this.methodes.add(new Methode(nom, type, accessibilite, motCle, attributs));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la methode " + methodes);
        }
    }

    public void ajouterConstructeur(String methodes) {
        try {
            String[] methodesTab = methodes.split("\\n");
            for (String methode : methodesTab) {
                String accessibilite = determinerAccessibilite(methode);
                String nom = methode.split(" ")[1].split("\\(")[0].replace("  ","");
                List<Attribut> attributs = determinerAttributs(methode);
                this.methodes.add(new Methode(nom, "", accessibilite, "", attributs));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du constructeur " + methodes);
        }
    }

    private List<Attribut> determinerAttributs(String methode) {
        String[] parametres = methode.split("\\(")[1].replace(")", "").split(",");
        List<Attribut> parametresList = new ArrayList<>();
        for (String parametre : parametres) {
            Attribut attribut = new Attribut("", parametre, "", "");
            parametresList.add(attribut);
        }
        return parametresList;
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

    private String determinerMotCle(String element) {
        String str = "";
        if (element.contains("abstract")){
            return "abstract";
        } else if (element.contains("final")){
            str += "final ";
        }
        if (element.contains("volatile")){
            str += "volatile ";
        }
        if (element.contains("static")){
            str += "static ";
        }
        if (element.contains("synchronized")){
            str += "synchronized ";
        }
        return str;
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

    public boolean isInterface() {
        return isInterface;
    }

    public void setInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }

    public void modifierAttribut(Attribut attribut, String visibilite, String type, String nom)
    {
        attribut.modifier(visibilite, type, nom);
    }

    public void modifierMethode(Methode methode, String visibilite, String type, String nom, List<Attribut> parametres)
    {
        methode.modifier(visibilite, type, nom, parametres);
    }

    public void modifierHeritage(Heritage heritage, ClasseInterface initClasse, ClasseInterface destinationClasse)
    {
        heritage.modifier(initClasse, destinationClasse);
    }

    public void modifierHeritage(Implementation implementation, ClasseInterface initClasse, ClasseInterface destinationClasse)
    {
        implementation.modifier(initClasse, destinationClasse);
    }

    public void modifierAssociation(Association association, String visibilite, String nom, ClasseInterface initClasse, ClasseInterface destinationClasse)
    {
        association.modifier(visibilite, nom, initClasse, destinationClasse);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void modifier(String nom, String type)
    {
        this.nom = nom;
        this.type = type;
    }
}
