package com.vue;

import com.modele.Modele;
import com.modele.export.ImageFormat;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;

public class VueExporter extends Application{

    private Modele modele;
    private VueFabriqueClasses vueFabriqueClasses;

    public VueExporter(Modele modele, VueFabriqueClasses vue) {
        this.modele = modele;
        this.vueFabriqueClasses = vue;
    }
    public void generer() {
        try {
            start(new Stage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //ImageFormat format = (ImageFormat) ImageFormat.getInstance();
        //format.saveImageFile(vueFabriqueClasses.exportImage(), primaryStage);
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "image files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(primaryStage);

        if (file != null) {
            String fileName = file.getName();

            if (!fileName.toUpperCase().endsWith(".PNG")) {
                file = new File(file.getAbsolutePath() + ".png");
            }

            ImageIO.write(SwingFXUtils.fromFXImage(vueFabriqueClasses.exportImage(), null),
                    "png", file);
        }
    }
}
