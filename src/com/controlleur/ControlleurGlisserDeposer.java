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
            double deltaX = mouseEvent.getSceneX() - mouseX;
            double deltaY = mouseEvent.getSceneY() - mouseY;
            p.relocate(p.getLayoutX() + deltaX, p.getLayoutY() + deltaY);
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
        }
    }
}
