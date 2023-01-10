package com.modele.composite;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FileDirectory extends FileComposite{

    public FileDirectory(String name, String path){
        super(name, path);
    }
    @Override
    public String list() {
        StringBuilder aff = new StringBuilder();
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (File fichier : Objects.requireNonNull(fichiers)) {
            FileComposite f;
            if (fichier.isDirectory()) {
                f = new FileDirectory("", fichier.getPath());
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


    public String arborescence(){
        String path = this.path;
        String str = "";
        File file = new File(path);
        str += file.getName()+"{";
        File[] fichiers = file.listFiles();
        for (File f: Objects.requireNonNull(fichiers)) {
            if (f.isDirectory()) {
                this.path = f.getPath();
                str += arborescence();
                if (str.endsWith(",")) {
                    str += str.substring(str.length() - 1);
                }
                str += "}\n";
                str += f.getName();
            } else if (f.isFile()) {
                if (f.getName().endsWith(".java")) {

                    str += f.getName() + ",";
                }
            }
        }
        return str;
    }
}