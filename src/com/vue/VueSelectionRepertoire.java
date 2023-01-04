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

    private Modele modele;
    private String path;
    private String name;

    public VueSelectionRepertoire(Modele modele) {
        this.modele = modele;
    }
    public void generer() {
        try {
            start(new Stage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Selectionner un repertoire");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        if(selectedDirectory != null){
            name = selectedDirectory.getName();
            path = selectedDirectory.getPath();
            modele.ouvrirDossier(name,path);
            modele.lireDossier();
        }
    }
}
