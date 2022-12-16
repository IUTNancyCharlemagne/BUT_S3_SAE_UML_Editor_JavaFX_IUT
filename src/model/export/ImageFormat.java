package model.export;

import composite.FileComposite;

import java.util.List;

public class ImageFormat implements Format
{
    ImageFormat instance;

    private ImageFormat()
    {

    }

    @Override
    public void exporter(List<FileComposite> fichiers)
    {

    }

    @Override
    public Format getInstance() {
        if (this.instance == null)
            this.instance = new ImageFormat();
        return this.instance;
    }
}
