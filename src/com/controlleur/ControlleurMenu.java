package com.controlleur;

import com.modele.Sujet;
import com.vue.VueAjouterClasse;
import com.vue.VueSelectionRepertoire;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ControlleurMenu implements EventHandler<ActionEvent> {

    private final Sujet modele;
    public ControlleurMenu(Sujet modele) {
        this.modele = modele;
    }
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof MenuItem m) {
            if (m.getId().equals("ajouterClasseJava")) {
                VueAjouterClasse vueAjouterClasse = new VueAjouterClasse(modele);
                try {
                    vueAjouterClasse.generer();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
