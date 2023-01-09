package com;

import com.controlleur.ControlleurGlisserDeposer;
import com.controlleur.ControlleurSouris;
import com.modele.Modele;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.vue.VueDiagramme;

public class Main extends Application {
    public static EventHandler<MouseEvent> controlleurSouris;
    public static EventHandler<MouseEvent> controlleurGlisserDeposer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Modele modele = new Modele();
        controlleurSouris = new ControlleurSouris(modele);
        controlleurGlisserDeposer = new ControlleurGlisserDeposer();
        VueGlobal vueGlobal = new VueGlobal(modele);
        primaryStage.setTitle("Diagramme de classe");
        primaryStage.setScene(new Scene(vueGlobal, 800, 600));
        primaryStage.show();
    }
}