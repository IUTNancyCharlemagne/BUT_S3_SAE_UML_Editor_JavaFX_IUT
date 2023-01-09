package com.vue;

import com.modele.Sujet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class VueAjouterClasse extends Application {
    public VueAjouterClasse(Sujet modele) {
    }

    public void generer() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VueContenuAjouterClasse vueContenuAjouterClasse = new VueContenuAjouterClasse();
        vueContenuAjouterClasse.generer();
        FlowPane flowPane = new FlowPane();
        flowPane.setPrefWidth(200);
        flowPane.setPrefHeight(200);
        flowPane.setStyle("-fx-background-color: #9b9b9b;");
        flowPane.getChildren().add(vueContenuAjouterClasse);
        primaryStage.setScene(new Scene(flowPane, 200, 200));
        primaryStage.show();
    }
}
