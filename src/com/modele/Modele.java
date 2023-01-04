package com.modele;

import com.modele.composite.FileDirectory;
import com.modele.elements.Element;
import com.vue.Observateur;
import com.modele.composite.FileComposite;
import com.modele.export.Format;

import java.util.ArrayList;
import java.util.List;

public class Modele implements Sujet
{
    private List<Observateur> observateurs;
    private List<Element> elements;
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
    public List<Element> getElements() {
        return elements;
    }
}
