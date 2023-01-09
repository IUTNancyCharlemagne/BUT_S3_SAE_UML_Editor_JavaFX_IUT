package com.controlleur;

import com.modele.Modele;
import com.modele.Sujet;
import com.vue.VueAjouterClasse;
import com.vue.VueExporter;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ControlleurMenu implements EventHandler<ActionEvent> {

    private final Sujet modele;
    private final VueGlobal vueGlobal;

    public ControlleurMenu(Sujet modele, VueGlobal vue) {
        this.modele = modele;
        this.vueGlobal = vue;
    }
    @Override
    public void handle(ActionEvent event) {
        System.out.println("ok");
        if (event.getSource() instanceof MenuItem m) {
            if (m.getId().equals("ajouterClasseJava")) {
                VueAjouterClasse vueAjouterClasse = new VueAjouterClasse(modele);
                try {
                    vueAjouterClasse.generer();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else if (m.getId().equals("btnExpImg"))
            {
                VueExporter vueExporter = new VueExporter((Modele) modele, vueGlobal.getVueFabriqueClasse());
                vueExporter.generer();
                modele.notifierObservateurs();
            }
        }
    }
}
