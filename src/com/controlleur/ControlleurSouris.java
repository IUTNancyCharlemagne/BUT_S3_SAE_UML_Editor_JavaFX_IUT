package com.controlleur;

import com.modele.Modele;
import com.vue.VueExporter;
import com.vue.VueGlobal;
import com.vue.VueSelectionRepertoire;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 */
public class ControlleurSouris implements EventHandler<MouseEvent> {

    /**
     * attributs privés qu'on ne peut pas modifier (final)
     */
    private final Modele modele;
    private final VueGlobal vueGlobal;

    /**
     * Constructeur de ControlleurSouris qui prend en paramètre les attributs modèle et vue
     * @param modele
     * @param vue
     */
    public ControlleurSouris(Modele modele, VueGlobal vue) {
        this.modele = modele;
        this.vueGlobal = vue;
    }

    /**
     * Méthode handle qui prend en paramètre event et qui permet de modifier le modele
     * @param event
     */
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof Label b) {
            switch (b.getId()) {
                /**Instruction 1 */
                case "btnOuvrir" -> {
                    VueSelectionRepertoire vueDirectorySelector = new VueSelectionRepertoire(modele);
                    vueDirectorySelector.generer();
                    modele.notifierObservateurs();
                }
                /**Instruction 2 */
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
