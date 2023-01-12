package com.modele.composite;

import java.io.*;
import java.util.*;

public class FileDirectory extends FileComposite{



    public FileDirectory(String name, String path, String finalPath) {
        super(name, path, finalPath);
    }
    @Override
    public String list() {
        StringBuilder aff = new StringBuilder();
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();

        for (File fichier : Objects.requireNonNull(fichiers)) {
            FileComposite f;
            if (fichier.isDirectory()) {
                System.out.println(fichier.getName());
                f = new FileDirectory(this.name + fichier.getName() + "." , fichier.getPath(), finalPath);
                aff.append(f.list());
            } else {
                if (fichier.getName().endsWith(".class")) {
                    String name = fichier.getName().replace(".class", "");
                    String classPackage = this.name+name;
                    System.out.println(classPackage);

                    if (name.equals("module-info")) {
                        classPackage = "";
                    }
                    f = new FileFile(classPackage, fichier.getPath(), finalPath);
                    aff.append("##########\n").append(f.list());
                }
            }
        }
        return aff.toString();
    }


    public ArborescenceDossier arborescence(){
        String path = this.path;
        File file = new File(path);
        File[] fichiers = file.listFiles();
        ArborescenceDossier arborescenceDossier = new ArborescenceDossier(file.getName());
        for (File f: Objects.requireNonNull(fichiers)) {
            if (f.isDirectory()) {
                this.path = f.getPath();
                arborescenceDossier.ajouterDossier(arborescence());
            } else if (f.isFile()) {
                if (f.getName().endsWith(".class")) {
                    String name = f.getName().replace(".class", "");
                    arborescenceDossier.ajouterFile(name);
                }
            }
        }
        return arborescenceDossier;
    }

}