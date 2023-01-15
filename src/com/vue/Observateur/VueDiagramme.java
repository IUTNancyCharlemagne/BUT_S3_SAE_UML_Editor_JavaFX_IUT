package com.vue.Observateur;

import com.Main;
import com.modele.Sujet;
import com.vue.Fabrique.VueFabriqueClasses;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

public class VueDiagramme extends Pane implements Observateur {

    VueFabriqueClasses vueFabriqueClasses;

    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setOnDragDropped(Main.controlleurGlisserDeposer);
        scrollPane.setOnDragOver(Main.controlleurGlisserDeposer);
        scrollPane.minWidthProperty().bind(this.widthProperty());
        scrollPane.minHeightProperty().bind(this.heightProperty());
        vueFabriqueClasses = new VueFabriqueClasses();
        scrollPane.setContent(vueFabriqueClasses);
        vueFabriqueClasses.clear();
        vueFabriqueClasses.generer(sujet, sujet.getClasses());
        this.getChildren().add(scrollPane);
    }


    public VueDiagramme() {
        super();
        this.setStyle("-fx-background-color: #ffffff");
    }

    public void export()
    {
        WritableImage img = this.snapshot(new SnapshotParameters(), null);
    }


    public VueFabriqueClasses getVueFabriqueClasses()
    {
        return this.vueFabriqueClasses;
    }
}
