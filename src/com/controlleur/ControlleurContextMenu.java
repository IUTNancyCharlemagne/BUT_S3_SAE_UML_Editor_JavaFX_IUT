package com.controlleur;

import com.vue.VueClasse;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;

public class ControlleurContextMenu implements EventHandler<ContextMenuEvent> {
    @Override
    public void handle(ContextMenuEvent contextMenuEvent) {
        if (contextMenuEvent.getEventType() == ContextMenuEvent.CONTEXT_MENU_REQUESTED){
            if (contextMenuEvent.getSource() instanceof VueClasse){
                VueClasse vueClasse = (VueClasse) contextMenuEvent.getSource();
                ContextMenu contextMenu = new ContextMenu();
                MenuItem ajouterElt = new MenuItem("Ajouter un element");
                MenuItem masquerAtt = new MenuItem("Masquer les attributs");
                MenuItem masquerMet = new MenuItem("Masquer les methodes");
                MenuItem masquerTout = new MenuItem("Masquer tout");
                contextMenu.getItems().addAll(ajouterElt, masquerAtt, masquerMet, masquerTout);
                contextMenu.show(vueClasse, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());
            }
        }
    }
}
