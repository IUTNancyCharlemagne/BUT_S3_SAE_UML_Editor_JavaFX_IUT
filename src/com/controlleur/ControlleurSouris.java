package com.controlleur;
import com.modele.Modele;
import com.vue.VueDiagramme;
import com.vue.VueExporter;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
                    System.out.println("bli");
                    VueSelectionRepertoire vueDirectorySelector = new VueSelectionRepertoire(modele);
                    vueDirectorySelector.generer();
                    modele.notifierObservateurs();
                }
                case "btnExpImg" -> {
                    System.out.println("ok");
                    VueExporter vueExporter = new VueExporter(modele, vueGlobal.getVueDiagramme());
                    vueExporter.generer();
                    modele.notifierObservateurs();
                }
                default -> {
                }
            }
        }
    }
}
