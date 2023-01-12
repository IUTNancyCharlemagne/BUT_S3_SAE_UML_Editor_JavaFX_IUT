package com.modele.composite;

import java.io.*;
import java.util.*;

public class FileDirectory extends FileComposite{

    public static String finalPath;

    public FileDirectory(String name, String path, String finalPath) {
        super(name, path, finalPath);
        FileDirectory.finalPath = finalPath;
    }
    @Override
    public String list() {
        StringBuilder aff = new StringBuilder();
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (File fichier : Objects.requireNonNull(fichiers)) {
            FileComposite f;
            if (fichier.isDirectory()) {
                f = new FileDirectory(this.name + fichier.getName() + "." , fichier.getPath(), finalPath);
                aff.append(f.list());
            } else {
                if (fichier.getName().endsWith(".class")) {
                    String classPackage = this.getPackageName(fichier);
                    f = new FileFile(classPackage, fichier.getPath(), finalPath);
                    aff.append("##########\n").append(f.list());
                }
            }
        }
        return aff.toString();
    }


    private String getPackageName(File fichier) {
        String name = fichier.getName().replace(".class", "");
        String classPackage = this.name+name;
        if (name.equals("module-info")) {
            classPackage = "";
        }
        return classPackage;
    }


    public ArborescenceDossier arborescence(){
        String path = this.path;
        File file = new File(path);
        File[] fichiers = file.listFiles();
        ArborescenceDossier arborescenceDossier = new ArborescenceDossier(file.getName(), file.getPath());
        for (File f: Objects.requireNonNull(fichiers)) {
            if (f.isDirectory()) {
                this.path = f.getPath();
                arborescenceDossier.ajouterDossier(arborescence());
            } else if (f.isFile()) {
                if (f.getName().endsWith(".class")) {
                    String name = this.getPackageName(f);
                    arborescenceDossier.ajouterFile(name, f.getPath());
                }
            }
        }
        return arborescenceDossier;
    }
}