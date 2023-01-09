package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

public class PlantUMLFormat implements Format
{
    private static PlantUMLFormat instance;

    private PlantUMLFormat()
    {

    }

    public void exporter(List<FileComposite> fichiers)
    {

    }

    public Format getInstance() {
        if (instance == null)
            instance = new PlantUMLFormat();
        return instance;
    }
}
