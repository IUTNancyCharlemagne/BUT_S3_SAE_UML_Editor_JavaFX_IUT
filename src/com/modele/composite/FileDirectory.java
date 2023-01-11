package com.modele.composite;

import java.io.*;
import java.util.*;

public class FileDirectory extends FileComposite{

    private final String finalPath;

    public FileDirectory(String name, String path, String finalPath) {
        super(name, path);
        this.finalPath = finalPath;
    }
    @Override
    public String list() {
        StringBuilder aff = new StringBuilder();
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (File fichier : Objects.requireNonNull(fichiers)) {
            FileComposite f;
            if (fichier.isDirectory()) {
                f = new FileDirectory("", fichier.getPath(),this.finalPath);
                aff.append(f.list());
            } else {
                if (fichier.getName().endsWith(".java")) {
                    String name = fichier.getName().substring(0, fichier.getName().length() - 5);
                    String classPackage = this.getPackageName(fichier);
                    String className;
                    if (!classPackage.equals("")) {
                        className = classPackage + "." + name;
                    } else {
                        className = name;
                    }

                    if (className.equals("module-info")) {
                        className = "";
                    }
                    f = new FileFile(className, fichier.getPath());
                    aff.append("##########\n").append(f.list());
                }
            }
        }
        return aff.toString();
    }

    private String getPackageName(File fichier) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fichier));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String line;
        String name = "";
        try {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("package")) {
                    name = line.substring(8, line.length() - 1);
                    break;
                }
                else if (line.startsWith("import") || line.startsWith("public class") || line.startsWith("public interface")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return name;
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
                if (f.getName().endsWith(".java")) {
                    name = f.getName().substring(0, f.getName().length() - 5);
                    arborescenceDossier.ajouterFile(name);
                }
            }
        }
        return arborescenceDossier;
    }

    public String getFinalPath() {
        return finalPath;
    }
}