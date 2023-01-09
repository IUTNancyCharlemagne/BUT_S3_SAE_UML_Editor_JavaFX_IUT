package com.vue;

import com.modele.Modele;
import com.modele.export.ImageFormat;
import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

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
        primaryStage.setTitle("Selectionner un repertoire");

        //test
        ImageFormat format = (ImageFormat) ImageFormat.getInstance();
        format.saveImageFile(vueFabriqueClasses.exportImage(), primaryStage);
    }
}
