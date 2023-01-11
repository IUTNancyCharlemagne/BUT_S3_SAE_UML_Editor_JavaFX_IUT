package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

/**
 *
 */
public class ImageFormat implements Format
{
    /**
     * Attribut privé et static
     */
    private static ImageFormat instance;

    /**
     * Constructeur de ImageFormat
     */
    private ImageFormat()
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
    public static Format getInstance() {
        if (instance == null)
            instance = new ImageFormat();
        return instance;
    }
}
