package com.vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class VueClasse extends FlowPane implements ElementDeVue{

    private Label titleLabel;
    private VBox content;
    private ArrayList<VueElementClasse> attributs;
    private ArrayList<VueElementClasse> methodes;

    private float posX, posY;

    public VueClasse() {
        super();
        content = new VBox();
        titleLabel = new Label();
        this.attributs = new ArrayList<>();
        this.methodes = new ArrayList<>();
        this.setStyle("-fx-background-color: #ffc75a");
        int nbAttributs = attributs.size();
        int nbMethodes = methodes.size();
        this.setMaxSize(200, 50 + 20 * (nbAttributs + nbMethodes));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPadding(new Insets(10, 10, 10, 10));

        this.getChildren().add(content);
    }

    public void setTitle(String title) {
        StackPane titlePane = new StackPane();
        this.titleLabel.setText(title);
        titlePane.getChildren().add(titleLabel);
        content.getChildren().add(titlePane);
    }

    public void setAttribut(VueElementClasse vueAttribut){
        this.attributs.add(vueAttribut);
        content.getChildren().add(vueAttribut);
    }

    public void setMethode(VueElementClasse vueElementClasse){
        this.methodes.add(vueElementClasse);
        content.getChildren().add(vueElementClasse);
    }

    public void setPos(float posX, float posY) {
        this.setLayoutX(posX);
        this.setLayoutY(posY);
    }

    public void ajouterSeparateur() {
        Line line = new Line(0, 100, 100  , 100);

        this.getChildren().add(line);
    }


}
