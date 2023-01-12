package com.modele.composite;

import java.io.*;
import java.util.*;

public class FileDirectory extends FileComposite{

    public static String finalPath;

    public FileDirectory(String name, String path, String finalPath) {
        super(name, path);
        FileDirectory.finalPath = finalPath;
    }
    @Override
    public String list() {
        StringBuilder aff = new StringBuilder();
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (File fichier : fichiers != null ? fichiers : new File[0]) {
            FileComposite f;
            if (fichier.isDirectory()) {
                f = new FileDirectory("", fichier.getPath(),FileDirectory.finalPath);
                aff.append(f.list());
            } else {
                if (fichier.getName().endsWith(".java")) {
                    String classPackage = this.getPackageName(fichier);
                    if (!classPackage.equals("")) {
                        classPackage += "."+fichier.getName();
                    } else {
                        classPackage = fichier.getName();
                    }

                    if (classPackage.equals("module-info.java")) {
                        classPackage = "";
                    }
                    classPackage = classPackage.replace(".java", "");
                    f = new FileFile(classPackage, this.path, FileDirectory.finalPath);
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
        ArborescenceDossier arborescenceDossier = new ArborescenceDossier(file.getName(), file.getPath());
        for (File f: Objects.requireNonNull(fichiers)) {
            if (f.isDirectory()) {
                this.path = f.getPath();
                arborescenceDossier.ajouterDossier(arborescence());
            } else if (f.isFile()) {
                if (f.getName().endsWith(".java")) {
                    name = f.getName().substring(0, f.getName().length() - 5);
                    arborescenceDossier.ajouterFile(name, f.getPath());
                }
            }
        }
        return arborescenceDossier;
    }

    public String getFinalPath() {
        return finalPath;
    }
}