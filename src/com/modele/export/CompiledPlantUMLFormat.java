package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

public class CompiledPlantUMLFormat implements Format
{
    private static CompiledPlantUMLFormat instance;

    private CompiledPlantUMLFormat()
    {

    }

    @Override
    public void exporter(List<FileComposite> fichiers)
    {

    }

    public Format getInstance() {
        if (instance == null)
            instance = new CompiledPlantUMLFormat();
        return instance;
    }
}
