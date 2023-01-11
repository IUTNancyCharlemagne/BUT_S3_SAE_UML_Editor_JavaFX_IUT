package com.vue;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 */
public class VueAssociation extends Pane implements ElementDeVue
{
    /**
     * Methode afficher qui prend en paramètre les attributs startX, startY, endX et endY
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public void afficher(double startX, double startY, double endX, double endY) {
        // obtenir la pente de la droite et trouver son angle
        double slope = (startY - endY) / (startX - endX);
        double lineAngle = Math.atan(slope);

        double arrowAngle = startX > endX ? Math.toRadians(45) : -Math.toRadians(225);

        Line line = new Line(startX, startY, endX, endY);

        double lineLength = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
        double arrowLength = lineLength / 10;

        // créer les jambes de la flèche
        Line arrow1 = new Line();
        arrow1.setStartX(line.getEndX());
        arrow1.setStartY(line.getEndY());
        arrow1.setEndX(line.getEndX() + arrowLength * Math.cos(lineAngle - arrowAngle));
        arrow1.setEndY(line.getEndY() + arrowLength * Math.sin(lineAngle - arrowAngle));

        Line arrow2 = new Line();
        arrow2.setStartX(line.getEndX());
        arrow2.setStartY(line.getEndY());
        arrow2.setEndX(line.getEndX() + arrowLength * Math.cos(lineAngle + arrowAngle));
        arrow2.setEndY(line.getEndY() + arrowLength * Math.sin(lineAngle + arrowAngle));

        this.getChildren().addAll(line, arrow1, arrow2);
    }
}
