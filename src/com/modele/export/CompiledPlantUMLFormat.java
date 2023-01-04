package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

public class CompiledPlantUMLFormat implements Format
{
    CompiledPlantUMLFormat instance;

    private CompiledPlantUMLFormat()
    {

    }

    @Override
    public void exporter(List<FileComposite> fichiers)
    {

    }

    @Override
    public Format getInstance() {
        if (this.instance == null)
            this.instance = new CompiledPlantUMLFormat();
        return this.instance;
    }
}
