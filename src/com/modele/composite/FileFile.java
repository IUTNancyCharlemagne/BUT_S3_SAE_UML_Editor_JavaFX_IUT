package com.modele.composite;

import java.io.File;
import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FileFile extends FileComposite{

    //Constructeur
    /**
     * Constructeur de FileFile qui prend en paramètre le nom et le chemin du fichier
     * @param name le nom de la classe
     * @param path l'extension du fichier
     */
    public FileFile(String name, String path, String finalPath) {
        super(name, path, finalPath);
    }

    @Override
    /**
     * Méthode list qui permet d'afficher le fichier
     * @return l'affichage console du fichier
     */
    public String list() {
        String aff = "";
        try {
            aff += this.contenu(this.name);
        }catch (ClassNotFoundException e){
            aff = ("La classe n'existe pas\n");
        }catch (MalformedURLException e) {
            aff = ("L'url n'est pas valide\n");
        }
        return aff;
    }

    /**
     * Méthode qui permet d'afficher le contenu d'un fichier .class
     * @param className le nom de la classe
     * @return l'affichage console du contenu du fichier .class
     * @throws ClassNotFoundException si la classe n'existe pas
     */
    public String contenu(String className) throws ClassNotFoundException, MalformedURLException {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(finalPath).toURI().toURL()});
        // On récupère la classe
        Class<?> classe = classLoader.loadClass(className);
        //On crée un StringBuilder qui contiendra l'affichage de la classe
        StringBuilder aff = new StringBuilder(classe.toGenericString() +"\nNOMCLASSE\n");

        //On récupère la classe mère
        Class<?> superclass = classe.getSuperclass();
        if (superclass != null) {
            aff.append("extends ").append(superclass.getSimpleName()).append("\n");
        }
        aff.append("HERITAGE");


        //On parcours les interfaces
        for (Class<?> c : classe.getInterfaces()) {
            aff.append("implements ").append(c.getSimpleName()).append("\n");
        }
        aff.append("IMPLEMENTATION");


        // On parcours les attributs de la classe
        for (Field f : classe.getDeclaredFields()){
            // On ajoute l'attribut à l'affichage
            aff.append(Modifier.toString(f.getModifiers())).append(" "); // On récupère l'accessibilité de l'attribut
            aff.append(f.getType().getSimpleName()).append(" "); // On récupère le type de l'attribut
            aff.append(f.getName().replace("java.lang.", "")); // On récupère le nom de l'attribut
            aff.append("\n");
        }
        aff.append("ATTRIBUTS");


        // On parcours les constructeurs de la classe
        for (Constructor<?> c : classe.getDeclaredConstructors()){
            // On ajoute le constructeur à l'affichage
            aff.append(Modifier.toString(c.getModifiers())).append(" "); // On récupère l'accessibilité du constructeur
            aff.append(c.getName().replace(classe.getPackageName()+".", "")); // On récupère le nom du constructeur
            aff.append("(");
            if (c.getParameterCount() > 0) {
                aff.append(this.affichageParametres(c.getParameters())); // On récupère les paramètres du constructeur
            }
            aff.append(")");
            aff.append("\n");
        }

        aff.append("CONSTRUCTEURS");

        // On parcours les méthodes de la classe
        for (Method m : classe.getDeclaredMethods()){
            // On ajoute la méthode à l'affichage
            aff.append(Modifier.toString(m.getModifiers())).append(" "); // Récupération de l'accessibilité
            aff.append(m.getReturnType().getSimpleName()).append(" "); // Récupération du type de retour
            aff.append(m.getName()); // Récupération du nom de la méthode
            aff.append("(");
            if (m.getParameterCount() > 0) {
                aff.append(this.affichageParametres(m.getParameters())); // Récupération des paramètres
            }
            aff.append(")");
            aff.append("\n");
        }
        aff.append("METHODES");
        // On retourne l'affichage
        return aff.toString();
    }

    private String affichageParametres(Parameter[] params){
        StringBuilder aff = new StringBuilder("");
        // On récupère le premier paramère du tableau
        aff.append(params[0].getType().getSimpleName()); // On récupère le type du paramètre
        int i = 1;
        // On parcours les autres paramètres
        while (i < params.length){
            aff.append(", ");
            aff.append(params[i].getType().getSimpleName()); // On récupère le type du paramètre
            i++;
        }
        return aff.toString();
    }
}