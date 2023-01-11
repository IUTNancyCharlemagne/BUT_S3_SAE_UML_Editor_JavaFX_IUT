package com.vue;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 *
 */
public class VueClasse extends FlowPane implements ElementDeVue{

    /**
     * Attribut public, static et final
     */
    public static final int INSETS = 10;
    /**
     * attributs privés
     */
    private Label titleLabel;
    private VBox content;
    private ArrayList<VueElementClasse> attributs;
    private ArrayList<VueElementClasse> methodes;

    private double posX, posY;

    private double width, height;

    /**
     * COnstructeur de VueClasse
     */
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
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));



        this.getChildren().add(content);
    }

    /**
     * Methode setTitle qui prend en paramètre l'attribut title
     * @param title
     */
    public void setTitle(String title) {
        StackPane titlePane = new StackPane();
        this.titleLabel.setText(title);
        titlePane.getChildren().add(titleLabel);
        content.getChildren().add(titlePane);
    }

    /**
     * Methode setAttribut qui prend en paramètre l'attribut vueAttribut
     * @param vueAttribut
     */
    public void setAttribut(VueElementClasse vueAttribut){
        this.attributs.add(vueAttribut);
        content.getChildren().add(vueAttribut);
    }

    /**
     * Methode setMethode qui prend en paramètre l'attribut vueElementClasse
     * @param vueElementClasse
     */
    public void setMethode(VueElementClasse vueElementClasse){
        this.methodes.add(vueElementClasse);
        content.getChildren().add(vueElementClasse);
    }

    /**
     * Methode setPos qui prend en paramètre l'attribut posX et posY
     * @param posX
     * @param posY
     */
    public void setPos(double posX, double posY) {
        this.setLayoutX(posX);
        this.setLayoutY(posY);
        this.posY = posY;
        this.posX = posX;
    }

    /**
     * Methode ajouterSeparateur qui ajoute un séparateur
     */
    public void ajouterSeparateur() {
        Separator separator = new Separator(Orientation.HORIZONTAL);
        separator.setHalignment(HPos.CENTER);
        Platform.runLater(() -> {
            separator.setPrefWidth(this.getWidth());
        });
        separator.setStyle("-fx-background-color: #000000");
        content.getChildren().add(separator);
    }

    /**
     * Methode setTaille qui prend en paramètre les attributs width et height
     * @param width
     * @param height
     */
    public void setTaille(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Methode getLargeur qui retourne l'attribut width
     * @return
     */
    public double getLargeur() {
        return this.width;
    }

    /**
     * Methode getHauteur qui retourne l'attribut height
     * @return
     */
    public double getHauteur() {
        return this.height;
    }

    /**
     * Methode getPosX qui retourne l'attribut posX
     * @return
     */
    public double getPosX() {
        return posX;
    }

    /**
     * Methode getPosY qui retourne l'attribut posY
     * @return
     */
    public double getPosY() {
        return posY;
    }
}
