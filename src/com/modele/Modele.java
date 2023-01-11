package com.modele;

import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;
import com.modele.elements.ClasseInterface;
import com.modele.export.Format;
import com.vue.Observateur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Modele implements Sujet
{
    /**
     * Attributs privés
     */
    private List<Observateur> observateurs;
    private List<ClasseInterface> elements;
    private FileDirectory dossier;
    private Format format;

    /**
     * Constructeur de Modele
     */
    public Modele()
    {
        this.observateurs = new ArrayList<Observateur>();
        this.elements = new ArrayList<>();
    }

    /**
     * Methode ajouterFichiers
     */
    public void ajouterFichiers()
    {

    }

    /**
     * Methode deplacerFichier qui prend en paramètre les attributs dx et dy
     * @param dx
     * @param dy
     */
    public void deplacerFichier(int dx, int dy)
    {

    }

    /**
     * Methode getFichiers qui retourne l'attribut arborescence de dossier
     * @return
     */
    public String getFichiers()
    {
        return this.dossier.arborescence();
    }


    /**
     * Methode supprimierFichiers qui prend en paramètre l'attribut fichier
     * @param fichier
     */
    public void supprimerFichiers(FileComposite fichier)
    {
    }


    /**
     * Methode enregistrerObservateur qui prend en paramètre l'attribut obs
     * @param obs
     */
    @Override
    public void enregistrerObservateur(Observateur obs) {
        this.observateurs.add(obs);
    }

    /**
     * * Methode supprimerObservateur qui prend en paramètre l'attribut obs
     * @param obs
     */
    @Override
    public void supprimerObservateur(Observateur obs) {
        this.observateurs.remove(obs);
    }

    /**
     * * Methode notifierObservateur
     */
    @Override
    public void notifierObservateurs() {
        for (Observateur obs : this.observateurs)
            obs.actualiser(this);
    }

    /**
     * Methode getClasses qui retourne l'attribut elements
     * @return
     */
    @Override
    public List<ClasseInterface> getClasses() {
        return elements;
    }

    /**
     * Permet d'instancier un dossier à partir de son nom et de son chemin
     * @param path le chemin du dossier
     */
    public void ouvrirDossier(String name, String path){
        this.dossier = new FileDirectory(name, path);
        notifierObservateurs();
    }

    /**
     * Methode lireDossier qui permet de lire un dossier
     */
    public void lireDossier(){
        try {
            String classes = this.dossier.list();
            String[] tabClasses = classes.split("##########");
            for (int i = 1; i < tabClasses.length; i++) {
                String[] tabNomClasse = tabClasses[i].split("NOMCLASSE");
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

                ClasseInterface classe = new ClasseInterface(tabNomClasse[0]);
                classe.ajouterHeritage(tabHeritage[0]);
                classe.ajouterImplementation(tabImplementations[0]);
                classe.ajouterAttribut(tabAttributs[0]);
                classe.ajouterConstructeur(tabConstructeurs[0]);
                classe.ajouterMethode(tabMethodes[0]);
                this.elements.add(classe);
            }
        } catch (Exception e) {
            System.out.println("La classe n'existe pas");
        }
    }
}
