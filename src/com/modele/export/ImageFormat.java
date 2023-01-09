package com.modele.export;

import com.modele.composite.FileComposite;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImageFormat implements Format
{
    private static ImageFormat instance;

    private ImageFormat()
    {

    }

    @Override
    public void exporter(List<FileComposite> fichiers)
    {

    }

    public static Format getInstance() {
        if (instance == null)
            instance = new ImageFormat();
        return instance;
    }
}
