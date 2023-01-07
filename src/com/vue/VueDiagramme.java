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

    private ArrayList<VueClasse> classesList;
    public void actualiser(Sujet sujet) {
        //this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        //this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        this.getChildren().clear();
        classesList = new ArrayList<>();
        List<ClasseInterface> classes = sujet.getClasses();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        FlowPane pane = new FlowPane();
        pane.setPrefSize(800,600);
        for (ClasseInterface classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            Group classeVue = new Group();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();

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
            pane.getChildren().add(classeVue);
        }
        scrollPane.setContent(pane);
        this.getChildren().add(scrollPane);
    }


    public VueDiagramme() {
        super();
        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
