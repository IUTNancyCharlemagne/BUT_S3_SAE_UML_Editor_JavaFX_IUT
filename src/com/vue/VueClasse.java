package com.vue;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class VueClasse extends FlowPane implements ElementDeVue{

    public static final int INSETS = 10;
    private Label titleLabel;
    private VBox content;
    private ArrayList<VueElementClasse> attributs;
    private ArrayList<VueElementClasse> methodes;

    private boolean deplacable = false;

    private double posX, posY;

    private double width, height;

    public VueClasse() {
        super();
        content = new VBox();
        titleLabel = new Label();
        this.attributs = new ArrayList<>();
        this.methodes = new ArrayList<>();
        this.setStyle("-fx-background-color: #ffc75a");
        int nbAttributs = attributs.size();
        int nbMethodes = methodes.size();
        width = 0;
        height = 0;
        posY = 0;
        posX = 0;
        this.setMaxSize(200, 50 + 20 * (nbAttributs + nbMethodes));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));



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

    public void ajouterSeparateur() {
        Separator separator = new Separator(Orientation.HORIZONTAL);
        separator.setHalignment(HPos.CENTER);
        Platform.runLater(() -> {
            separator.setPrefWidth(this.getWidth());
        });
        separator.setStyle("-fx-background-color: #000000");
        content.getChildren().add(separator);
    }

    public void setTaille(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getLargeur() {
        return this.width;
    }

    public double getHauteur() {
        return this.height;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void selectionner() {
        if (!deplacable) {
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.BLACK);
            shadow.setBlurType(BlurType.GAUSSIAN);
            shadow.setRadius(10);
            shadow.setOffsetX(5);
            this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            this.setEffect(shadow);
        }else {
            this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            this.setEffect(null);
        }
        this.deplacable = !deplacable;
    }

    public void deplacer(double posX, double posY) {
        this.setLayoutX(posX);
        this.setLayoutY(posY);
    }

    public void MoveRandom() {
        this.setLayoutX(Math.random() * 1000);
        this.setLayoutY(Math.random() * 1000);
    }
}
