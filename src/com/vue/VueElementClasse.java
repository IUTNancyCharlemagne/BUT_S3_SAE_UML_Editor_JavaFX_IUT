package com.vue;

import com.modele.elements.Attribut;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class VueElementClasse extends HBox implements ElementDeVue {

    private Label nameText;
    private Rectangle accessibilityRect;

    private Label motCle;
    private Label[] parametersText;
    private Label typeText;
    public VueElementClasse() {
        super();
        this.setAlignment(Pos.BASELINE_LEFT);
    }

    public void setName(String name) {
        this.nameText = new Label(name);
        this.getChildren().add(nameText);
    }

    public void setParameters(List<Attribut> parameters) {
        this.parametersText = new Label[parameters.size()];
        int i = 0;
        Label parametersLabel = new Label("(");
        Label parametersLabel2 = new Label(")");
        this.getChildren().add(parametersLabel);
        for (Attribut parameter : parameters) {
            this.parametersText[i] = new Label(parameter.getType());
            this.getChildren().add(this.parametersText[i]);
            i++;
        }
        this.getChildren().add(parametersLabel2);
    }

    public void setType(String type) {
        this.typeText = new Label(type);
        this.typeText.setPadding(new Insets(0, 10, 0, 10));
        this.getChildren().add(typeText);
    }

    public void setMotCle(String motCle) {
        this.motCle = new Label(motCle);
        this.motCle.setPadding(new Insets(0, 10, 0, 10));
        this.getChildren().add(this.motCle);
    }

    public void setAccessibility(String accessibility) {
        this.accessibilityRect = new Rectangle(10,10);
        switch (accessibility) {
            case "public" -> this.accessibilityRect.setFill(Color.GREEN);
            case "private" -> this.accessibilityRect.setFill(Color.RED);
            case "protected" -> this.accessibilityRect.setFill(Color.YELLOW);
            default -> this.accessibilityRect.setFill(Color.WHITE);
        }
        this.getChildren().add(accessibilityRect);
    }


}
