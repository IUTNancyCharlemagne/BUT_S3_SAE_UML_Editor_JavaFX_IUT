package com.modele;

import com.modele.composite.FileDirectory;
import com.modele.elements.ClasseInterface;
import com.modele.elements.Element;
import com.vue.Observateur;
import com.modele.composite.FileComposite;
import com.modele.export.Format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Modele implements Sujet
{
    private List<Observateur> observateurs;
    private List<ClasseInterface> elements;
    private FileDirectory dossier;
    private Format format;

    public Modele()
    {
        this.observateurs = new ArrayList<Observateur>();
        this.elements = new ArrayList<>();
    }

    public void ajouterFichiers()
    {

    }

    public void deplacerFichier(int dx, int dy)
    {

    }

    public String getFichiers()
    {
        return this.dossier.list();
    }



    public void supprimerFichiers(FileComposite fichier)
    {
    }


    @Override
    public void enregistrerObservateur(Observateur obs) {

    }

    @Override
    public void supprimerObservateur(Observateur obs) {

    }

    @Override
    public void notifierObservateurs() {

    }

    @Override
    public List<ClasseInterface> getClasses() {
        return elements;
    }

    /**
     * Permet d'instancier un dossier à partir de son nom et de son chemin
     * @param path le chemin du dossier
     */
    public void ouvrirDossier(String path){
        this.dossier = new FileDirectory("", path);
    }

    public void lireDossier(){
        try {
            String classes = this.dossier.list();
            String[] tabClasses = classes.split("##########");
            for (int i = 1; i < tabClasses.length; i++) {
                String[] tabNomClasse = tabClasses[i].split("NOMCLASSE");
                String[] tabHeritage = tabNomClasse[1].split("HERITAGE");
                String[] tabImplementations = tabHeritage[1].split("IMPLEMENTATION");
                String[] tabAttributs = tabImplementations[1].split("ATTRIBUTS");
                String[] tabMethodes = tabAttributs[1].split("METHODES");

                ClasseInterface classe = new ClasseInterface(tabNomClasse[0]);
                classe.ajouterHeritage(tabHeritage[0]);
                classe.ajouterImplementation(tabImplementations[0]);
                classe.ajouterAttribut(tabAttributs[0]);
                classe.ajouterMethode(tabMethodes[0]);
                this.elements.add(classe);
            }
        } catch (Exception e) {
            System.out.println("La classe n'existe pas");
        }
    }
}
