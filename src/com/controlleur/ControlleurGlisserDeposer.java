package com.controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;

public class ControlleurGlisserDeposer implements EventHandler<MouseEvent> {

    private double mouseX;
    private double mouseY;
    @Override
    public void handle(MouseEvent mouseEvent) {
        FlowPane p = (FlowPane) mouseEvent.getSource();
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
        } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED){
            p.relocate(mouseEvent.getSceneX() - mouseX, mouseEvent.getSceneY() - mouseY);
        }
    }
}
