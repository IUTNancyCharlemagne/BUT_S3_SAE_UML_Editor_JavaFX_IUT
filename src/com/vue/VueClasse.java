package com.vue;

import com.Main;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class VueClasse extends FlowPane implements ElementDeVue{

    private final Label titleLabel;
    private final VBox content;
    private final ArrayList<VueElementClasse> attributs;
    private final ArrayList<VueElementClasse> methodes;
    public static final int INSETS = 10;
    private ArrayList<VueElementClasse> attributs;
    private ArrayList<VueElementClasse> methodes;
    private List<ImageView> imageViews;

    public VueClasse() {
        super();
        this.setOnMousePressed(Main.controlleurGlisserDeposer);
        this.setOnMouseDragged(Main.controlleurGlisserDeposer);
        content = new VBox();
        titleLabel = new Label();
        this.attributs = new ArrayList<>();
        this.methodes = new ArrayList<>();
        this.setStyle("-fx-background-color: #ffc75a");
        int nbAttributs = attributs.size();
        int nbMethodes = methodes.size();
        this.setMaxSize(50 + 20 * (nbAttributs + nbMethodes), 50 + 20 * (nbAttributs + nbMethodes));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        imageViews = new ArrayList<>();
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-border-color: black;" +
                "-fx-border-radius: 5px;" +
                "-fx-background-radius: 5px;" +
                "-fx-background-color: #ffc75a;");

        this.getChildren().add(content);
    }

    public void setMinSize(double width, double height) {
        super.setMinSize(width, height);
    }

    public void setTitle(String title) {
        StackPane titlePane = new StackPane();
        this.titleLabel.setText(title);
        this.titleLabel.setStyle("-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: black;" +
                "-fx-padding: 0 0 0 0;");
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

    public void setPos(double posX, double posY) {
        this.setLayoutX(posX);
        this.setLayoutY(posY);
    }

    public void ajouterSeparateur() {
        Separator separator = new Separator(Orientation.HORIZONTAL);
        separator.setHalignment(HPos.CENTER);
        separator.getStylesheets().add("separator.css");
        // Quand on modifie une classe la taille du conteneur est défini alors on peut directement faire le getWidth

        // Quand on génére un diagramme entier la taille du conteneur n'est pas défini alors on fais runLater
        Platform.runLater(() -> {
            System.out.println("width 1 : " + this.getWidth());
            separator.setPrefWidth(this.getWidth());
        });
        if (separator.getPrefWidth() == 0) {
            separator.setPrefWidth(this.getWidth());
        }
        separator.setPadding(new Insets(10, 0, 10, 0));
        content.getChildren().add(separator);
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

    public void imageAdd(String id) {
        StackPane stackPaneImageView = new StackPane();
        ImageView imageView = new ImageView("add.png");
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        imageView.setId(id);
        stackPaneImageView.getChildren().add(imageView);
        stackPaneImageView.setAlignment(Pos.CENTER_RIGHT);
        imageViews.add(imageView);
        content.getChildren().add(stackPaneImageView);
    }

    public List<ImageView> getImageView() {
        return imageViews;
    }
}
