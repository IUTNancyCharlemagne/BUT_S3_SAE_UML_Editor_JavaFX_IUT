package com.vue;

import com.modele.elements.*;
import javafx.application.Platform;
import javafx.scene.Group;

import com.modele.Sujet;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Transform;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VueDiagramme extends Pane implements Observateur {

    public void actualiser(Sujet sujet) {
        ScrollPane scrollPane = new ScrollPane();
        this.getChildren().clear();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        VueFrabriqueClasses vueFrabriqueClasses = new VueFrabriqueClasses();
        vueFrabriqueClasses.generer(sujet);
        scrollPane.setContent(vueFrabriqueClasses);
        this.getChildren().add(scrollPane);
    }


    public VueDiagramme() {
        super();
        this.setStyle("-fx-background-color: #ffffff");
    }

    public WritableImage exportImage()
    {
        return this.snapshot(new SnapshotParameters(), null);
    }

    public void export()
    {
        WritableImage img = this.snapshot(new SnapshotParameters(), null);
    }



}
