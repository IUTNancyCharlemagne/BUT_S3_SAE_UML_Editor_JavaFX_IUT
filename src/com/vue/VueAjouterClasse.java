package com.vue;

import com.modele.Sujet;
import com.modele.elements.ClasseInterface;
import com.vue.Fabrique.VueFabriqueClasses;
import com.vue.Fabrique.elements.VueClasse;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        demonstration = new VueClasse();
        controlleurAjouterClasse.setVueClasse(demonstration);
    }

    public void generer() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        controlleurAjouterClasse.setVueClasse(demonstration);
        Button btnAjouter = new Button("Ajouter la classe au diagramme");
        btnAjouter.setId("ajouterClasseDiag");
        Button cancel = new Button("Cancel");
        cancel.setId("cancel");
        btnAjouter.setOnMouseClicked(controlleurAjouterClasse);
        cancel.setOnMouseClicked(controlleurAjouterClasse);
        flowPane.getChildren().addAll(btnAjouter,cancel);
        genererPrev();
        primaryStage.setScene(new Scene(flowPane, 550, 300));
        primaryStage.setTitle("Ajouter une classe");
        primaryStage.show();
    }

    public static void genererPrev() {
        flowPane.getChildren().remove(demonstration);
        ClasseInterface classeCourante = modele.getClasseCourante();
        if (classeCourante == null) {
            demonstration = new VueClasse();
            demonstration.ajouterTitre();
        }
        VueFabriqueClasses fabriqueClasses = new VueFabriqueClasses();
        fabriqueClasses.generer(modele, Collections.singletonList(classeCourante));
        if (classeCourante != null) {
            demonstration = fabriqueClasses.getClassesList().get(0);
        }
        controlleurAjouterClasse.setVueClasse(demonstration);
        flowPane.getChildren().add(demonstration);
    }

    public static void exit() {
        Platform.exit();
    }
}
