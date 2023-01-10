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

    @Override
    public HashMap<String, ArrayList<String>> arborescence(){
        HashMap<String, ArrayList<String>> aff = new HashMap<>();
        aff.put(this.name, new ArrayList<>());
        File monDossier = new File(this.path);
        File[] contenuDossier = monDossier.listFiles();
        if (contenuDossier != null) {
            for (File element : contenuDossier) {
                FileComposite f;
                if (element.isDirectory()) {
                    f = new FileDirectory("\t" + element.getName(), element.getPath());
                    aff.get(this.name).add(f.arborescence().keySet().toArray()[0].toString());
                    for (String key : f.arborescence().keySet()) {
                        aff.put(key, f.arborescence().get(key));
                    }
                } else {
                    f = new FileFile(element.getName(), element.getPath());
                    aff.get(this.name).add(f.arborescence().keySet().toArray()[0].toString());
                }
            }
        }
        return aff;
    }
}