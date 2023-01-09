package com.controlleur;
import com.modele.Sujet;
import com.vue.VueAjouterClasse;
import com.vue.VueClasse;
import com.vue.VueExporter;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControlleurSouris implements EventHandler<MouseEvent> {

    private final Sujet modele;
    private final VueGlobal vueGlobal;


    public ControlleurSouris(Sujet modele, VueGlobal vue) {
        this.modele = modele;
        this.vueGlobal = vue;
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof Label l) {
            if (l.getId().equals("btnOuvrir")) {
                VueSelectionRepertoire vueDirectorySelector = new VueSelectionRepertoire(modele);
                vueDirectorySelector.generer();
                modele.notifierObservateurs();
            }else if (l.getId().equals("btnExpImg")) {
                VueExporter vueExporter = new VueExporter(modele, vueGlobal.getVueFabriqueClasse());
                vueExporter.generer();
                modele.notifierObservateurs();
            }
        }
    }
}
