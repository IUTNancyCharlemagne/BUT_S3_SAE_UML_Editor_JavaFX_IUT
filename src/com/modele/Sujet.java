package com.modele;

import com.modele.elements.ClasseInterface;
import com.modele.elements.Element;
import com.vue.Observateur;

import java.util.List;

public interface  Sujet
{
    public void enregistrerObservateur(Observateur obs);

    public void supprimerObservateur(Observateur obs);

    public void notifierObservateurs();

    List<ClasseInterface> getClasses();

    void ouvrirDossier(String name, String path,String finalPath);

    void lireDossier();

    void ajouterClasse(String classeJava);

    void ajouterClasseDiagramme();

    ClasseInterface getClasseCourante();

    List<ClasseInterface> getClassesUtilisateurs();

    void retirerClasseCourante();
}
