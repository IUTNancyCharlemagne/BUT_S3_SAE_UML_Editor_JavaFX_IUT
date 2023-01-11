package com.modele.composite;

import java.util.ArrayList;
import java.util.List;

public class ArborescenceDossier {
    private final List<ArborescenceDossier> arborescence;
    private final String nom;
    private final List<String> files;

    public ArborescenceDossier(String nom){
        this.arborescence = new ArrayList<>();
        this.files = new ArrayList<>();
        this.nom = nom;
    }
    public List<ArborescenceDossier> getArborescence() {
        return arborescence;
    }

    public void ajouterFile(String file) {
        this.files.add(file);
    }

    public void ajouterDossier(ArborescenceDossier arborescenceDossier) {
        this.arborescence.add(arborescenceDossier);
    }

    public List<String> getFiles() {
        return files;
    }

    public String getNom() {
        return nom;
    }

    public boolean isEmptyDirectory(){
        return this.arborescence.isEmpty();
    }

    @Override
    public String toString() {
        return "ArborescenceDossier{" +
                "nom='" + nom + "' " +
                "arborescence=" + arborescence +
                ", files=" + files +
                '}';
    }
}
