package com.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class VueElementClasse extends HBox implements ElementDeVue {

    private Label nameText;
    private Rectangle accessibilityRect;

    private Label[] parametersText;
    private Label typeText;
    public VueElementClasse() {
        super();
        this.setMinSize(150, 20);
        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    public void setName(String name) {
        this.nameText = new Label(name);
        this.getChildren().add(nameText);
    }

    public void setParameters(String[] parameters) {
        this.parametersText = new Label[parameters.length];
        int i = 0;
        for (String parameter : parameters) {
            this.parametersText[i] = new Label(parameter);
            this.getChildren().add(this.parametersText[i]);
            i++;
        }
    }

    public void setType(String type) {
        this.typeText = new Label(type);
        this.typeText.setPadding(new Insets(0, 10, 0, 10));
        this.getChildren().add(typeText);
    }

    public void setAccessibility(String accessibility) {
        this.accessibilityRect = new Rectangle(10,10);
        switch (accessibility) {
            case "public" -> this.accessibilityRect.setFill(Color.GREEN);
            case "private" -> this.accessibilityRect.setFill(Color.RED);
            case "protected" -> this.accessibilityRect.setFill(Color.YELLOW);
        }
        this.getChildren().add(accessibilityRect);
    }
}
