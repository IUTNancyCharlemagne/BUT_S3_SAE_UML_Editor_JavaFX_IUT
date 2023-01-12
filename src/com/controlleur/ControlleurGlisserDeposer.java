package com.controlleur;

import com.modele.Modele;
import javafx.event.EventHandler;
import javafx.scene.input.*;

public class ControlleurGlisserDeposer implements EventHandler<DragEvent> {

    private Modele modele;

    public ControlleurGlisserDeposer(Modele modele) {
        this.modele = modele;
    }
    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        if (dragEvent.getEventType() == DragEvent.DRAG_OVER){
            if (db.hasString()){
                dragEvent.acceptTransferModes(TransferMode.MOVE);
                dragEvent.consume();
            }
        } else if (dragEvent.getEventType() == DragEvent.DRAG_DROPPED){
            if (db.hasString()){
                String classe = db.getString();
                System.out.println(classe);
                modele.lireClasse(classe);
                modele.notifierObservateurs();
                dragEvent.setDropCompleted(true);
                dragEvent.consume();
            }
        }
    }
}
