package com.vue;

import com.modele.Modele;
import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 *
 */
public class VueSelectionRepertoire extends Application{

    /**
     * Attributs privés
     */
    private Modele modele;
    private String path;
    private String name;

    /**
     * Constructeur de VueSelectionRepertoire qui prend en paramètre l'attribut modele
     * @param modele
     */
    public VueSelectionRepertoire(Modele modele) {
        this.modele = modele;
    }

    /**
     * Methode generer
     */
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

    /**
     * Methode start
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Selectionner un repertoire");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        if(selectedDirectory != null){
            name = selectedDirectory.getName();
            path = selectedDirectory.getPath();
            modele.ouvrirDossier(name, path);
            modele.lireDossier();
        }
    }
}
