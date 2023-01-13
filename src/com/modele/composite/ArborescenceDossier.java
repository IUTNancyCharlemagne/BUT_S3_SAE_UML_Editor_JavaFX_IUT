package com.modele.composite;

import java.util.ArrayList;
import java.util.List;

public class ArborescenceDossier {
    private final List<ArborescenceDossier> arborescence;
    private final String nom;

    private final String path;
    private final List<List<String>> files;

    public ArborescenceDossier(String nom, String path){
        this.path = path;
        this.arborescence = new ArrayList<>();
        this.files = new ArrayList<>();
        this.nom = nom;
    }
    public List<ArborescenceDossier> getArborescence() {
        return arborescence;
    }

    public void ajouterFile(String file, String path) {
        this.files.add(List.of(file, path));
    }

    public void ajouterDossier(ArborescenceDossier arborescenceDossier) {
        this.arborescence.add(arborescenceDossier);
    }

    public List<List<String>> getFiles() {
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

    public String getPath() {
        return path;
    }
}
