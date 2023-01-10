package com.vue;

import com.modele.Sujet;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class VueContenuAjouterClasse extends ScrollPane {

    private FlowPane flowPane;
    private Sujet modele;


    private VueClasse vueClasse;


    public VueContenuAjouterClasse(Sujet modele) {
        this.modele = modele;
        flowPane = new FlowPane();
        this.setPrefSize(500, 300);
        flowPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0);" +
                "-fx-padding: 0 0 0 10;");
        flowPane.setAlignment(Pos.CENTER);
    }

    public void generer() {
        // Exemple de visualisation
        addTitre();
        this.flowPane.getChildren().addAll(vueClasse);
        this.setContent(this.flowPane);
    }

    public void addTitre() {

    }



    /**
     * Ajoute un titre à la future classe
     */






}
