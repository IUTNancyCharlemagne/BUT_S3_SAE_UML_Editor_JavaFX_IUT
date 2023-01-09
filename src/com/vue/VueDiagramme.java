package com.vue;

import com.modele.elements.*;
import javafx.application.Platform;
import javafx.scene.Group;

import com.modele.Sujet;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VueDiagramme extends Pane implements Observateur {

    public void actualiser(Sujet sujet) {
        ScrollPane scrollPane = new ScrollPane();
        this.getChildren().clear();
        scrollPane.minWidthProperty().bind(this.widthProperty());
        scrollPane.minHeightProperty().bind(this.heightProperty());
        VueFrabriqueClasses vueFrabriqueClasses = new VueFrabriqueClasses();
        vueFrabriqueClasses.generer(sujet, sujet.getClasses());
        scrollPane.setContent(vueFrabriqueClasses);
        vueFrabriqueClasses.generer(sujet);
        this.getChildren().add(scrollPane);
    }


    public VueDiagramme() {
        super();
        this.setStyle("-fx-background-color: #ffffff");
    }
}
