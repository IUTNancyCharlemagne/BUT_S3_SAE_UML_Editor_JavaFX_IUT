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

    public VueElementClasse() {
        super();
        this.setAlignment(Pos.BASELINE_LEFT);
    }

    public void setName(String name) {
        if (name == null || name.equals("")) return;
        Label nameText = new Label(name);
        nameText.setPadding(new Insets(0, 0, 0, 10));
        this.getChildren().add(nameText);
    }

    public void setParameters(List<Attribut> parameters) {
        if (parameters.size() == 0) return;

        Label[] parametersText = new Label[parameters.size()];
        Label parametersLabel = new Label("(");
        Label parametersLabel2 = new Label(")");
        this.getChildren().add(parametersLabel);
        for (int i = 0; i < parameters.size(); i++) {
            parametersText[i] = new Label(parameters.get(0).getType());
            this.getChildren().add(parametersText[i]);
            if (parameters.size() - 1 > i) {
                Label virgule = new Label(", ");
                this.getChildren().add(virgule);
            }
        }
        this.getChildren().add(parametersLabel2);
    }

    public void setType(String type) {
        if (type == null || type.equals("")) return;
        Label typeText = new Label(type);
        typeText.setPadding(new Insets(0, 0, 0, 10));
        this.getChildren().add(typeText);
    }

    public void setMotCle(String motCle) {
        if (motCle == null || motCle.equals("")) return;
        Label motCle1 = new Label(motCle);
        motCle1.setPadding(new Insets(0, 0, 0,10));
        this.getChildren().add(motCle1);
    }

    public void setAccessibility(String accessibility) {
        Rectangle accessibilityRect = new Rectangle(10, 10);
        switch (accessibility) {
            case "public" -> accessibilityRect.setFill(Color.GREEN);
            case "private" -> accessibilityRect.setFill(Color.RED);
            case "protected" -> accessibilityRect.setFill(Color.YELLOW);
            default -> accessibilityRect.setFill(Color.WHITE);
        }
        this.getChildren().add(accessibilityRect);
    }


}
