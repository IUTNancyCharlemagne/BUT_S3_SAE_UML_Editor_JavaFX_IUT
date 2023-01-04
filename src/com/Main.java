package com;

import com.modele.Modele;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.vue.VueDiagramme;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Modele modele = new Modele();
        VueGlobal vueGlobal = new VueGlobal(modele);
        primaryStage.setTitle("Diagramme de classe");
        primaryStage.setScene(new Scene(vueGlobal, 800, 600));
        primaryStage.show();
    }
}