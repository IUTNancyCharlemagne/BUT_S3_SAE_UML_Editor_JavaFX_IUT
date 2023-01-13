package com.controlleur;

import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;
import com.modele.composite.FileFile;
import com.vue.VueClasse;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
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
            String[] file = text.getId().split("DOSSIER");
            FileComposite fileComposite;
            ClipboardContent content = new ClipboardContent();
            if (file.length == 2) {
                fileComposite = new FileDirectory(text.getText(), file[1], FileDirectory.finalPath);
                content.putString("DOSSIER"+fileComposite.list());
            }
            else {
                System.out.println(text.getId());
                fileComposite = new FileFile(text.getText(), text.getId(), FileDirectory.finalPath);
                content.putString(fileComposite.list());
            }
            dragboard.setContent(content);
            mouseEvent.consume();
        }
    }
}
