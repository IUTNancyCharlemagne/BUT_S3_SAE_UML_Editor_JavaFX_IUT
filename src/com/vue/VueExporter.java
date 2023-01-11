package com.vue;

import com.modele.Sujet;
import com.modele.export.ImageFormat;
import javafx.application.Application;
import javafx.stage.Stage;

public class VueExporter extends Application{

    private Sujet modele;
    private VueFabriqueClasses vueFabriqueClasses;

    private String typeExport;

    public VueExporter(Sujet modele, VueFabriqueClasses vue, String type) {
        this.modele = modele;
        this.vueFabriqueClasses = vue;
        this.typeExport = type;
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
        ImageFormat format = (ImageFormat) ImageFormat.getInstance();
        format.exporter(vueFabriqueClasses.exportImage(), primaryStage);
    }
}
