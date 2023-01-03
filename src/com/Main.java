package com;

import com.model.Modele;
import com.vue.VueDiagramme;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Diagramme de classe");
        VueDiagramme vueDiagramme = new VueDiagramme();
        vueDiagramme.actualiser(new Modele());
        primaryStage.setScene(new Scene(vueDiagramme, 800, 600));
        primaryStage.show();
    }
}