package model;

import model.elements.Classe;

import java.util.ArrayList;
import java.util.List;

public class Modele implements Sujet
{
    private List<Observateur> observateurs;
    private List<Classe> classes;
    private FileComposite dossier;
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

    public List<FileComposite> getFichiers()
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
