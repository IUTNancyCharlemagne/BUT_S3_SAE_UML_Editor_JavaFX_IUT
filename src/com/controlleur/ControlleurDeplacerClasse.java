package com.controlleur;

import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;
import com.modele.composite.FileFile;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class ControlleurDeplacerClasse implements EventHandler<MouseEvent> {

    private double mouseX;
    private double mouseY;
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
            FlowPane p = (FlowPane) mouseEvent.getSource();
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
            p.toFront();
        } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED){
            FlowPane p = (FlowPane) mouseEvent.getSource();
            double deltaX = mouseEvent.getSceneX() - mouseX;
            double deltaY = mouseEvent.getSceneY() - mouseY;
            p.relocate(p.getLayoutX() + deltaX, p.getLayoutY() + deltaY);
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
        } else if (mouseEvent.getEventType() == MouseEvent.DRAG_DETECTED) {
            Text text = (Text) mouseEvent.getSource();
            Dragboard dragboard = text.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            FileComposite fileComposite = new FileFile(text.getText(), "", FileDirectory.finalPath);
            content.putString(fileComposite.list());
            dragboard.setContent(content);
            mouseEvent.consume();
        }
    }
}
