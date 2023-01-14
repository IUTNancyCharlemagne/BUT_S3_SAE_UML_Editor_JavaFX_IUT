package com.controlleur;

import com.modele.Modele;
import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;
import com.modele.composite.FileFile;
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
                String[] file = classe.split("DOSSIER");
                if (file.length == 2) {
                    modele.lireDossier(file[1]);
                }
                else {
                    modele.lireClasse(classe);
                }
                modele.notifierObservateurs();
                dragEvent.setDropCompleted(true);
                dragEvent.consume();
            }
        }
    }
}
