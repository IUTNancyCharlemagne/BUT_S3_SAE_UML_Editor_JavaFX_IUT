package com.controlleur;
import com.modele.Modele;
import com.vue.VueSelectionRepertoire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControlleurSouris implements EventHandler<MouseEvent> {

    private final Modele modele;
    public ControlleurSouris(Modele modele) {
        this.modele = modele;
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof Label b) {
            switch (b.getId()) {
                case "btnOuvrir":
                    VueSelectionRepertoire vueDirectorySelector = new VueSelectionRepertoire(modele);
                    vueDirectorySelector.generer();
                    modele.notifierObservateurs();
                    break;
                default:
                    break;
            }
        }
    }
}
