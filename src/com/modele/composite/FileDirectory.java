package com.modele.composite;

import java.io.*;

public class FileDirectory extends FileComposite{

    public FileDirectory(String name, String path){
        super(name, path);
    }
    @Override
    public String list() {
        String aff = "";
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (int i = 0; i < fichiers.length; i++){
            File fichier = fichiers[i];
            FileComposite f;
            if (fichiers[i].isDirectory()){
                    f = new FileDirectory("", fichier.getPath());
                aff += f.list();
            }
            else {

                if (fichier.getName().endsWith(".java")) {
                    String name = fichier.getName().substring(0, fichier.getName().length() - 5);
                    String classPackage = this.getPackageName(fichier);
                    String className;
                    if (!classPackage.equals("")) {
                        className = classPackage + "." + name;
                    }
                    else {
                        className = name;
                    }

                    if (className.equals("module-info")) {
                        className="";
                    }
                    f = new FileFile(className, fichier.getPath());
                    aff += "##########\n" + f.list();
                }
            }
        }
        return aff;
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
}