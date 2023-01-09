package com.modele.export;

import com.modele.composite.FileComposite;

import java.util.List;

public interface Format
{
    public void exporter(List<FileComposite> fichiers);
}
