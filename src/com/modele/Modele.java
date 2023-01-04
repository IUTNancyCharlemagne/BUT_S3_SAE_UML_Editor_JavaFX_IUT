package com.modele;

import com.modele.composite.FileDirectory;
import com.vue.Observateur;
import com.modele.composite.FileComposite;
import com.modele.elements.Classe;
import com.modele.export.Format;

import java.util.ArrayList;
import java.util.List;

public class Modele implements Sujet
{
    private List<Observateur> observateurs;
    private List<Classe> classes;
    private FileDirectory dossier;
    private Format format;

    public Modele()
    {
        this.observateurs = new ArrayList<Observateur>();
        this.classes = new ArrayList<Classe>();
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
}
