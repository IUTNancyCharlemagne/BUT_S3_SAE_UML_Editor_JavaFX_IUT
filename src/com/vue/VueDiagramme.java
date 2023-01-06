package com.vue;

import com.modele.elements.*;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.skin.ScrollPaneSkin;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import com.modele.Sujet;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import static com.vue.VueClasse.INSETS;

public class VueDiagramme extends ScrollPane implements Observateur {

    private ArrayList<VueClasse> classesList;
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        classesList = new ArrayList<>();
        List<ClasseInterface> classes = sujet.getClasses();
        for (ClasseInterface classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            Group classeVue = new Group();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();

            Platform.runLater(() -> {
                for (VueClasse vue : classesList) {
                    vue.setTaille(vue.getWidth(), vue.getHeight());
                    for (int i = 1; i < classesList.size(); i++) {
                        VueClasse v = classesList.get(i-1);
                        Random random = new Random();
                        int x = random.nextInt(100);
                        int y = random.nextInt(100);
                        classesList.get(i).setPos(v.getPosX() + v.getLargeur()+x, v.getPosY()+y);
                    }
                }
            });

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


    public VueDiagramme() {
        super();
        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
