package model.export;

import composite.FileComposite;

import java.util.List;

public interface Format
{
    public void exporter(List<FileComposite> fichiers);
    public Format getInstance();
}
