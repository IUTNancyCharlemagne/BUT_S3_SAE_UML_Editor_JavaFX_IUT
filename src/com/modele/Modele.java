package com.modele;

import com.modele.composite.ArborescenceDossier;
import com.modele.composite.FileDirectory;
import com.modele.elements.ClasseInterface;
import com.vue.Observateur;
import com.modele.composite.FileComposite;
import com.modele.export.Format;

import java.util.*;

public class Modele implements Sujet
{
    private List<Observateur> observateurs;
    private List<ClasseInterface> elements;
    private List<ClasseInterface> classesUtilisateurs;
    private ClasseInterface classeCourante;
    private FileDirectory dossier;
    private Format format;

    public Modele()
    {
        this.observateurs = new ArrayList<>();
        this.elements = new ArrayList<>();
        this.classesUtilisateurs = new ArrayList<>();
    }

    public void ajouterFichiers()
    {

    }

    public void deplacerFichier(int dx, int dy)
    {

    }

    public ArborescenceDossier getFichiers()
    {
        ArborescenceDossier arborescence = this.dossier.arborescence();
        this.dossier.setPath(this.dossier.getFinalPath());
        return arborescence;
    }



    public void supprimerFichiers(FileComposite fichier)
    {
    }


    @Override
    public void enregistrerObservateur(Observateur obs) {
        this.observateurs.add(obs);
    }

    @Override
    public void supprimerObservateur(Observateur obs) {
        this.observateurs.remove(obs);
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur obs : this.observateurs)
            obs.actualiser(this);
    }

    @Override
    public List<ClasseInterface> getClasses() {
        return elements;
    }

    /**
     * Permet d'instancier un dossier à partir de son nom et de son chemin
     * @param path le chemin du dossier
     */
    public void ouvrirDossier(String name, String path,String finalPath){
        this.dossier = new FileDirectory(name, path, finalPath);
    }

    public void lireDossier(){
        String classes = this.dossier.list();
        lireDossier(classes);
    }

    public void lireDossier(String classes){
        try {
            String[] tabClasses = classes.split("##########");
            for (int i = 1; i < tabClasses.length; i++) {
                this.lireClasse(tabClasses[i]);
            }
        } catch (Exception e) {
            System.out.println("La classe n'existe pas");
        }
    }

    public void lireClasse(String classe){
        try {
            String[] tabNomClasse = classe.split("NOMCLASSE");
            String[] tabHeritage = tabNomClasse[1].split("HERITAGE");
            String[] tabImplementations = tabHeritage[1].split("IMPLEMENTATION");
            String[] tabAttributs = tabImplementations[1].split("ATTRIBUTS");
            String[] tabConstructeurs = tabAttributs[1].split("CONSTRUCTEURS");
            String[] tabMethodes = tabConstructeurs[1].split("METHODES");
            tabMethodes = !Arrays.equals(tabMethodes, new String[0]) ? tabMethodes : new String[]{""};
            tabConstructeurs = !Arrays.equals(tabConstructeurs, new String[0]) ? tabConstructeurs : new String[]{""};
            tabHeritage = !Arrays.equals(tabHeritage, new String[0]) ? tabHeritage : new String[]{""};
            tabAttributs = !Arrays.equals(tabAttributs, new String[0]) ? tabAttributs : new String[]{""};
            tabImplementations = !Arrays.equals(tabImplementations, new String[0]) ? tabImplementations : new String[]{""};

            ClasseInterface classeInterface = new ClasseInterface(tabNomClasse[0]);
            classeInterface.ajouterHeritage(tabHeritage[0]);
            classeInterface.ajouterImplementation(tabImplementations[0]);
            classeInterface.ajouterAttribut(tabAttributs[0]);
            classeInterface.ajouterConstructeur(tabConstructeurs[0]);
            classeInterface.ajouterMethode(tabMethodes[0]);
            this.elements.add(classeInterface);
        }catch (Exception e){
            System.out.println("La classe n'existe pas");
        }
    }

    @Override
    public void ajouterClasse(String classeJava) {
        this.classeCourante = new ClasseInterface("");
        this.classeCourante.setNom(classeJava);
    }

    public void ajouterClasseDiagramme() {
        this.classesUtilisateurs.add(this.classeCourante);
        this.classeCourante = null;
    }

    @Override
    public ClasseInterface getClasseCourante() {
        return classeCourante;
    }

    public List<ClasseInterface> getClassesUtilisateurs() {
        return classesUtilisateurs;
    }

    public void retirerClasseCourante(){
        this.classeCourante = null;
    }

    public void reinitialiser() {
        this.classesUtilisateurs = new ArrayList<>();
        this.classeCourante = null;
        this.elements = new ArrayList<>();
    }
}
