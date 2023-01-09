package com.vue;

import com.controlleur.ControlleurSouris;
import com.modele.Sujet;
import com.modele.elements.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Transform;

import java.util.ArrayList;
import java.util.List;

public class VueFabriqueClasses extends AnchorPane {

    private ArrayList<VueClasse> classesList;

    public void generer(Sujet sujet) {
        classesList = new ArrayList<>();
        List<ClasseInterface> classes = sujet.getClasses();
        this.getChildren().clear();

        this.setPrefSize(800,600);
        for (ClasseInterface classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            Group classeVue = new Group();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();
            AnchorPane.setTopAnchor(vueElement,0.0);
            vueElement.MoveRandom();
            vueElement.setId(classe.getNom());
            vueElement.setOnMouseClicked(new ControlleurSouris(sujet));
            vueElement.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // update the node's coordinates based on the mouse event
                    vueElement.setLayoutX(event.getSceneX() - 200);
                    vueElement.setLayoutY(event.getSceneY() - 50);
                    System.out.println("X: " + event.getX() + " Y: " + event.getY());
                    event.consume();
                }
            });

            vueElement.setPrefSize(200, 200);
            vueElement.setTitle(classe.getNom());
            vueElement.ajouterSeparateur();

            for (Attribut attribut : classe.getAttributs()) {
                fabriqueDeVue = new FabriqueVueAttribut();

                VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();

                vueAttribut.setAccessibility(attribut.getVisibilite());
                vueAttribut.setType(attribut.getType());
                vueAttribut.setName(attribut.getNom());

                vueElement.setAttribut(vueAttribut);
            }
            vueElement.ajouterSeparateur();
            for (Methode methode : classe.getMethodes()) {
                fabriqueDeVue = new FabriqueVueMethode();

                VueElementClasse vueMethode = (VueElementClasse) fabriqueDeVue.creerVueElement();

                vueMethode.setAccessibility(methode.getVisibilite());
                vueMethode.setType(methode.getType());
                vueMethode.setName(methode.getNom());
                vueMethode.setParameters(methode.getParametres());

                vueElement.setMethode(vueMethode);
            }

            for (Association association : classe.getAssociations()) {

            }

            for (Implementation implementation : classe.getImplementations()) {

            }
            classeVue.getChildren().add(vueElement);
            classesList.add(vueElement);
            this.getChildren().add(classeVue);
        }
    }


    public WritableImage exportImage()
    {
        SnapshotParameters spa = new SnapshotParameters();
        spa.setTransform(Transform.scale(3, 3));
        return this.snapshot(spa, null);
    }
}
