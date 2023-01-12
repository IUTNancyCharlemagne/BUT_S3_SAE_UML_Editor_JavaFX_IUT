package com.modele.composite;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class FileComposite{

    // Attributs
    /**
     * 2 attributs de type String correspondant au nom et au chemin du fichier
     */
    protected String name, path;
    protected String finalPath;

    // Constructeur
    /**
     * Constructeur de FileComposite qui prend en paramètre le nom et le chemin du fichier
     * @param name le nom du fichier
     * @param path le chemin du fichier
     */
    public FileComposite(String name, String path, String finalPath){
        this.name = name;
        this.path = path;
        this.finalPath = finalPath;
    }

    // Méthodes
    /**
     * Méthode list qui permet d'afficher le fichier ou le contenu du dossier
     * @return l'affichage console du fichier ou du dossier
     */
    public abstract String list();

    public void setPath(String path) {
        this.path = path;
    }

    public String getFinalPath() {
        return finalPath;
    }

    public String getName() {
        return name;
    }
}