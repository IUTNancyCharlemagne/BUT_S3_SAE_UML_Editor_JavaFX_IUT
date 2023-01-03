package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

public class PlantUMLFormat implements Format
{
    PlantUMLFormat instance;

    private PlantUMLFormat()
    {

    }

    @Override
    public void exporter(List<FileComposite> fichiers)
    {

    }

    @Override
    public Format getInstance() {
        if (this.instance == null)
            this.instance = new PlantUMLFormat();
        return this.instance;
    }
}
