package com.controlleur;

import com.vue.Fabrique.elements.VueClasse;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;

public class ControlleurContextMenu implements EventHandler<ContextMenuEvent> {
    @Override
    public void handle(ContextMenuEvent contextMenuEvent) {
        if (contextMenuEvent.getEventType() == ContextMenuEvent.CONTEXT_MENU_REQUESTED) {
            if (contextMenuEvent.getSource() instanceof VueClasse vueClasse) {

                ContextMenu contextMenu = new ContextMenu();
                Menu menu = new Menu("Masquer/Afficher");
                MenuItem ajouterElt = new MenuItem("Ajouter un element");

                MenuItem masquerAtt = new MenuItem("Masquer les attributs");
                masquerAtt.setOnAction(event -> vueClasse.masquerAttributs());

                MenuItem masquerMet = new MenuItem("Masquer les methodes");
                masquerMet.setOnAction(event -> vueClasse.masquerMethodes());

                MenuItem masquerTout = new MenuItem("Masquer tout");
                masquerTout.setOnAction(event -> vueClasse.masquerTout());

                MenuItem afficherAtt = new MenuItem("Afficher les attributs");
                afficherAtt.setOnAction(event -> vueClasse.agrandirAttributs());

                MenuItem afficherMet = new MenuItem("Afficher les methodes");
                afficherMet.setOnAction(event -> vueClasse.agrandirMethodes());

                MenuItem afficherTout = new MenuItem("Afficher tout");
                afficherTout.setOnAction(event -> vueClasse.agrandirTout());

                if (vueClasse.isAttributsVisible()) {
                    menu.getItems().add(masquerAtt);
                }else {
                    menu.getItems().add(afficherAtt);
                }
                if (vueClasse.isMethodesVisible()) {
                    menu.getItems().add(masquerMet);
                }else {
                    menu.getItems().add(afficherMet);
                }
                menu.getItems().addAll(masquerTout, afficherTout);

                contextMenu.getItems().add(menu);
                contextMenu.show(vueClasse, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());
            }
        }
    }
}
