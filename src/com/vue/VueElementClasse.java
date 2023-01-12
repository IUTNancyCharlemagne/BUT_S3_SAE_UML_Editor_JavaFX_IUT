package com.vue;

import com.modele.elements.Attribut;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.List;

import static com.Main.controlleurAjouterClasse;

public class VueElementClasse extends HBox implements ElementDeVue {

    private String nom;

    public VueElementClasse() {
        super();
        this.setAlignment(Pos.BASELINE_LEFT);
    }

    public void setName(String name) {
        if (name == null || name.equals("")) return;
        this.nom = name;
        Label nameText = new Label(name);
        nameText.setPadding(new Insets(0, 0, 0, 10));
        this.getChildren().add(nameText);
    }

    public void setParameters(List<Attribut> parameters) {
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


    public void imageAdd(String id) {
        StackPane stackPaneImageView = new StackPane();
        ImageView imageView = new ImageView("add.png");
        imageView.setFitHeight(15);
        imageView.setFitWidth(15);
        stackPaneImageView.setId(id);
        imageView.setId(nom);
        stackPaneImageView.getChildren().add(imageView);
        stackPaneImageView.setAlignment(Pos.BOTTOM_LEFT);
        stackPaneImageView.setOnMouseClicked(controlleurAjouterClasse);
        this.getChildren().add(this.getChildren().size() - 1,stackPaneImageView);
    }

    public TextField ajouterParametre() {
        HBox parametre = new HBox();
        ImageView imageView = new ImageView("check.png");
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setSmooth(true);
        imageView.setId("checkParam."+nom);
        imageView.setOnMouseClicked(controlleurAjouterClasse);
        TextField textField = new TextField();
        textField.setPromptText("Type");
        parametre.getChildren().addAll(textField, imageView);
        parametre.setAlignment(Pos.CENTER);
        this.getChildren().add(this.getChildren().size() - 2,parametre);
        return textField;
    }

    public String getNom() {
        return nom;
    }
}
