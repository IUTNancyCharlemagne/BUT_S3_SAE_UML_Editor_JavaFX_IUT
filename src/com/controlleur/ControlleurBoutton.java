package com.controlleur;
import com.modele.Modele;
import com.vue.VueSelectionRepertoire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControlleurBoutton implements EventHandler<ActionEvent> {

    private final Modele modele;
    public ControlleurBoutton(Modele modele) {
        this.modele = modele;
    }
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button b) {
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
