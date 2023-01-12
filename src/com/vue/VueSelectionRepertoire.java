package com.vue;

import com.modele.Modele;
import com.modele.Sujet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;

public class VueSelectionRepertoire extends Application{

    private final Sujet modele;
    private String path;
    private String name;

    public VueSelectionRepertoire(Sujet modele) {
        this.modele = modele;
    }
    public void generer() {
        start(new Stage());
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Selectionner un repertoire");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        if(selectedDirectory != null){
            name = selectedDirectory.getName();
            path = selectedDirectory.getPath();
            modele.reinitialiser();
            modele.ouvrirDossier(name, path,path);
            modele.lireDossier();
            modele.notifierObservateurs();
        }
    }
}
