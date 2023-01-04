package com.vue;

import com.modele.Modele;
import javafx.scene.layout.BorderPane;

public class VueGlobal extends BorderPane {
    private VueMenu vueMenu;
    private VueDiagramme vueDiagramme;
    private Modele modele;

    public VueGlobal(Modele modele) {
        this.modele = modele;
        initBorderPane();
    }

    public void initBorderPane() {
        vueMenu = new VueMenu();
        vueDiagramme = new VueDiagramme();
        vueMenu.actualiser(modele);
        vueDiagramme.actualiser(modele);
        this.setTop(vueMenu);
        this.setCenter(vueDiagramme);
    }
}
