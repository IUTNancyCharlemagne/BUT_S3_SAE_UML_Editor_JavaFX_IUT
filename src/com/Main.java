package com;

import com.modele.Modele;
import com.vue.VueGlobal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 */
public class Main extends Application {
    /**
     * Methode start
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Modele modele = new Modele();
        VueGlobal vueGlobal = new VueGlobal(modele);

        primaryStage.setTitle("Diagramme de classe");
        primaryStage.setScene(new Scene(vueGlobal, 800, 600));
        primaryStage.show();
    }
}