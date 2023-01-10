package com.modele.composite;

import java.io.*;
import java.util.*;

public class FileDirectory extends FileComposite{

    public FileDirectory(String name, String path){
        super(name, path);
    }
    @Override
    public String list() {
        StringBuilder aff = new StringBuilder();
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (File fichier : fichiers != null ? fichiers : new File[0]) {
            FileComposite f;
            if (fichier.isDirectory()) {
                f = new FileDirectory("", fichier.getPath());
                aff.append(f.list());
            } else {
                if (fichier.getName().endsWith(".java")) {
                    String classPackage = this.getPackageName(fichier);
                    if (!classPackage.equals("")) {
                        classPackage += "."+fichier.getName();
                    }else {
                        classPackage = fichier.getName();
                    }

                    if (classPackage.equals("module-info.java")) {
                        classPackage = "";
                    }
                    classPackage = classPackage.replace(".java", "");
                    f = new FileFile(classPackage, this.path);
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

    @Override
    public String arborescence(){
        String aff = this.name;
        File monDossier = new File(this.path);
        File[] contenuDossier = monDossier.listFiles();
        for (File element : contenuDossier != null ? contenuDossier : new File[0]) {
            FileComposite f;
            if (element.isDirectory()) {
                f = new FileDirectory("\t" + element.getName(), element.getPath());
                aff += f.arborescence() + "SEPARATEUR";
            } else {
                f = new FileFile(element.getName(), element.getPath());
                aff += f.arborescence();
            }
        }
        return aff;
    }
}