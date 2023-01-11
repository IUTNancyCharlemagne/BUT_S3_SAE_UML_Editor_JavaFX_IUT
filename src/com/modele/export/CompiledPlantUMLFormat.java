package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

/**
 *
 */
public class CompiledPlantUMLFormat implements Format
{
    /**
     * Attribut privé et static
     */
    private static CompiledPlantUMLFormat instance;

    /**
     * Constructeur de CompiledPlandUMLFormat
     */
    private CompiledPlantUMLFormat()
    {

    }

    /**
     * Methode exporter qui prend en paramètre l'attribut fichiers
     * @param fichiers
     */
    @Override
    public void exporter(List<FileComposite> fichiers)
    {

    }

    /**
     * Methode getInstance qui retourne l'attribut instance
     * @return
     */
    public Format getInstance() {
        if (instance == null)
            instance = new CompiledPlantUMLFormat();
        return instance;
    }
}
