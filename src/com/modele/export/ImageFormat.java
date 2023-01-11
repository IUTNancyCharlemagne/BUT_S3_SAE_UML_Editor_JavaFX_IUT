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

    public static Format getInstance() {
        if (instance == null)
            instance = new ImageFormat();
        return instance;
    }

    @Override
    public void exporter(List<FileComposite> fichiers) {

    }

    public void exporter(WritableImage writableImage,
                         Stage stage) throws IOException {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "image files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            String fileName = file.getName();

            if (!fileName.toUpperCase().endsWith(".PNG")) {
                file = new File(file.getAbsolutePath() + ".png");
            }

            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null),
                    "png", file);
        }
    }
}
