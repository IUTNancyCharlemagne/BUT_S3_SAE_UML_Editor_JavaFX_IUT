package com.vue;

import com.controlleur.ControlleurAjouterClasse;
import com.modele.Sujet;
import com.modele.elements.ClasseInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Collections;

import static com.Main.controlleurAjouterClasse;


public class VueAjouterClasse extends Application {

    private static Sujet modele;
    private static FlowPane flowPane;
    private static VueClasse demonstration;

    public VueAjouterClasse(Sujet sujet) {
        modele = sujet;
        demonstration =  new VueClasse();
        controlleurAjouterClasse.setVueClasse(demonstration);
    }

    public void generer() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        flowPane = new FlowPane();
        flowPane.setPrefWidth(500);
        flowPane.setPrefHeight(300);
        controlleurAjouterClasse.setVueClasse(demonstration);
        genererPrev();
        demonstration.ajouterTitre();
        primaryStage.setScene(new Scene(flowPane, 500, 300));
        primaryStage.show();
    }

    public static void genererPrev() {
        flowPane.getChildren().remove(demonstration);
        ClasseInterface classeCourante = modele.getClasseCourante();

        VueFabriqueClasses fabriqueClasses = new VueFabriqueClasses();
        fabriqueClasses.generer(modele, Collections.singletonList(classeCourante));
        if (classeCourante != null) {
            demonstration = fabriqueClasses.getClassesList().get(0);
            for (ImageView img : fabriqueClasses.getClassesList().get(0).getImageView()) {
                img.setOnMouseClicked(controlleurAjouterClasse);
            }
        }
        flowPane.getChildren().add(demonstration);
    }
}
