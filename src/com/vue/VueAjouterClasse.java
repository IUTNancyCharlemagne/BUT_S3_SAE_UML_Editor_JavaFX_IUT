package com.vue;

import com.modele.Sujet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class VueAjouterClasse extends Application {

    private final Sujet modele;
    public VueAjouterClasse(Sujet modele) {
        this.modele = modele;
    }

    public void generer() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VueContenuAjouterClasse vueContenuAjouterClasse = new VueContenuAjouterClasse(modele);
        vueContenuAjouterClasse.genererPrev();
        vueContenuAjouterClasse.generer();
        FlowPane flowPane = new FlowPane();
        flowPane.setPrefWidth(500);
        flowPane.setPrefHeight(300);
        flowPane.getChildren().add(vueContenuAjouterClasse);
        primaryStage.setScene(new Scene(flowPane, 500, 300));
        primaryStage.show();
    }
}
