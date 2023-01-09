package com.controlleur;
import com.modele.Sujet;
import com.vue.VueAjouterClasse;
import com.vue.VueClasse;
import com.vue.VueSelectionRepertoire;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControlleurSouris implements EventHandler<MouseEvent> {

    private final Sujet modele;
    public ControlleurSouris(Sujet modele) {
        this.modele = modele;
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof VueClasse vueClasse) {
            vueClasse.selectionner();
        }else if (event.getSource() instanceof Label l) {
            if (l.getId().equals("btnOuvrir")) {
                VueSelectionRepertoire vueDirectorySelector = new VueSelectionRepertoire(modele);
                vueDirectorySelector.generer();
                modele.notifierObservateurs();
            }
        }
    }


}
