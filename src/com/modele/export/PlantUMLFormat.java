package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

/**
 *
 */
public class PlantUMLFormat implements Format
{
    /**
     * Attribut privé et static
     */
    private static PlantUMLFormat instance;

    /**
     * COnstructeur de PlantUMLFormat
     */
    private PlantUMLFormat()
    {

    }

    /**
     * Methode exporter qui prend en paramètre l'attribut fichiers
     * @param fichiers
     */
    public void exporter(List<FileComposite> fichiers)
    {

    }

    /**
     * Methode getInstance qui retourne l'attribut instance
     * @return
     */
    public Format getInstance() {
        if (instance == null)
            instance = new PlantUMLFormat();
        return instance;
    }
}
