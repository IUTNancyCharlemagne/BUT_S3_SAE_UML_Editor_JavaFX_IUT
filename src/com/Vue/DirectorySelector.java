package com.Vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.Modele;
import model.Sujet;

import java.io.File;

public class DirectorySelector extends Application implements Observateur {

    private Modele modele;
    public DirectorySelector(Modele modele) {
        this.modele = modele;
    }
    @Override
    public void actualiser(Sujet sujet) {
        try {
            start(new Stage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choisir un dossier");
        directoryChooser.setInitialDirectory(new File("src"));
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        String path = selectedDirectory.getPath();
        String name = selectedDirectory.getName();

        primaryStage.show();
    }
}
