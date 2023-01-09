package com.vue;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueContenuAjouterClasse extends ScrollPane {

    private HBox hBox;
    public VueContenuAjouterClasse() {
        hBox = new HBox();
        this.setPrefWidth(200);
        this.setPrefHeight(200);
        this.setStyle("-fx-background-color: #9b9b9b;");
    }

    public void generer() {
        addTitre();
    }

    /**
     * Ajoute un titre à la future classe
     */
    private void addTitre() {
        VBox vBox = new VBox();
        Label titre = new Label("Nom de la classe");
        titre.setStyle("-fx-font-size: 20px;");
        TextField saisiTitre = new TextField();
        saisiTitre.setPrefWidth(150);
        saisiTitre.setStyle("-fx-font-size: 20px;" +
                "-fx-border-radius: 5px;" +
                "-fx-background-radius: 5px;");
        ImageView imageView = new ImageView("check.png");
        vBox.getChildren().addAll(titre, saisiTitre,imageView);
        hBox.getChildren().add(vBox);
    }
}
