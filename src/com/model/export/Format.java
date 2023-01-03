package com.model.export;

import com.model.composite.FileComposite;

import java.util.List;

public interface Format
{
    public void exporter(List<FileComposite> fichiers);
    public Format getInstance();
}
