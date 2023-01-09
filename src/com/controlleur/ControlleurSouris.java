package com.controlleur;
import com.modele.Modele;
import com.vue.VueExporter;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControlleurSouris implements EventHandler<MouseEvent> {

    private final Modele modele;
    private final VueGlobal vueGlobal;

    public ControlleurSouris(Modele modele, VueGlobal vue) {
        this.modele = modele;
        this.vueGlobal = vue;
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof Label b) {
            switch (b.getId()) {
                case "btnOuvrir" -> {
                    VueSelectionRepertoire vueDirectorySelector = new VueSelectionRepertoire(modele);
                    vueDirectorySelector.generer();
                    modele.notifierObservateurs();
                }
                case "btnExpImg" -> {
                    VueExporter vueExporter = new VueExporter(modele, vueGlobal.getVueFabriqueClasse());
                    vueExporter.generer();
                    modele.notifierObservateurs();
                }
                default -> {
                }
            }
        }
    }
}
