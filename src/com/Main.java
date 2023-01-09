package com;

import com.controlleur.ControlleurGlisserDeposer;
import com.controlleur.ControlleurMenu;
import com.controlleur.ControlleurSouris;
import com.modele.Modele;
import com.modele.export.Format;
import com.modele.export.ImageFormat;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
    public static EventHandler<ActionEvent> controlleurMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Modele modele = new Modele();
        controlleurGlisserDeposer = new ControlleurGlisserDeposer();
        controlleurMenu = new ControlleurMenu(modele);
        VueGlobal vueGlobal = new VueGlobal(modele);
        controlleurSouris = new ControlleurSouris(modele, vueGlobal);

        primaryStage.setTitle("Diagramme de classe");
        primaryStage.setScene(new Scene(vueGlobal, 800, 600));
        primaryStage.show();
    }
}