package com.vue;

import com.Main;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

import static com.Main.controlleurAjouterClasse;

public class VueClasse extends FlowPane implements ElementDeVue{

    private final Label titleLabel;
    private static VBox content;
    private final ArrayList<VueElementClasse> attributs;
    private final ArrayList<VueElementClasse> methodes;
    private final List<ImageView> imageViews;
    private String type;

    private TextField saisiTitre;
    private TextField saisiAccessibilite;
    private TextField saisiType;
    private Boolean etreMethode;
    private HBox ajoutElem;


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
        etreMethode = false;
        type = "";
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
        ajouterType();
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
        Platform.runLater(() -> separator.setPrefWidth(this.getWidth()));
        separator.getStylesheets().add("separator.css");
        separator.setPadding(new javafx.geometry.Insets(1.5, 0, 1.5, 0));
        content.getChildren().add(separator);
    }

    public double getLargeur() {
        double[] largeur = new double[1];
        Platform.runLater(() -> largeur[0] = this.getWidth());
        return largeur[0];
    }

    public double getHauteur(){
        double[] hauteur = new double[1];
        Platform.runLater(() -> hauteur[0] = this.getHeight());
        return hauteur[0];
    }

    public void deplacer(double posX, double posY) {
        this.setLayoutX(posX);
        this.setLayoutY(posY);
    }

    public void imageAdd(String id) {
        StackPane stackPaneImageView = new StackPane();
        ImageView imageView = new ImageView("add.png");
        imageView.setSmooth(true);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        stackPaneImageView.setId(id);
        stackPaneImageView.getChildren().add(imageView);
        stackPaneImageView.setAlignment(Pos.CENTER_RIGHT);
        stackPaneImageView.setOnMouseClicked(controlleurAjouterClasse);
        imageViews.add(imageView);
        content.getChildren().add(stackPaneImageView);
    }

    public List<ImageView> getImageView() {
        return imageViews;
    }

    public void ajouterAttribut(String nom) {
        // Ajout des attributs
        ajoutElem = new HBox();
        ajoutElem.getChildren().clear();
        saisiAccessibilite = textfield("Accessibilité");
        ajoutElem.getChildren().addAll(saisiAccessibilite);
        int placement = attributs.size() + 4;
        if (nom.equals("Methode")) {
            placement += methodes.size() + 2;
        }
        content.getChildren().add(placement, ajoutElem);
        addNom(ajoutElem,nom);
        ajoutElem.setAlignment(Pos.CENTER);
    }

    public void ajouterMethode() {
        etreMethode = true;
        ajouterAttribut("Methode");
    }

    private TextField textfield(String nom) {
        TextField textField = new TextField();
        textField.setFocusTraversable(false);
        textField.setPrefWidth(150);
        textField.setStyle("-fx-font-size: 15px;" +
                "-fx-border-radius: 5px;" +
                "-fx-background-radius: 5px;" +
                "-fx-label-padding: 0 0 10 0;" +
                "-fx-padding: 2 0 2 10;");
        textField.setPromptText(nom);
        return textField;
    }

    private ImageView image(String path) {
        // Ajout du bouton de validation avec une image personnalisée
        ImageView imageView = new ImageView(path);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setStyle("-fx-translate-x: -10");
        imageView.setId("validerTitre");
        return imageView;
    }

    public Boolean getEtreMethode() {
        if (etreMethode) {
            etreMethode = false;
            return true;
        }
        return false;
    }

    public TextField getSaisiTitre() {
        return saisiTitre;
    }

    public TextField getSaisiType() {
        return saisiType;
    }

    public TextField getSaisiAccessibilite() {
        return saisiAccessibilite;
    }

    private void addNom(HBox hBox,String nom) {
        // Ajout du titre
        hBox.setAlignment(Pos.CENTER);

        saisiTitre = textfield(nom);
        saisiType = textfield("Type");


        ImageView imageView = image("check.png");
        imageView.setId("check");
        imageView.setOnMouseClicked(controlleurAjouterClasse);


        // On ajoute tous les éléments aux la vue
        hBox.getChildren().addAll(saisiType,saisiTitre,imageView);
    }

    public void ajouterTitre() {
        HBox box = new HBox();
        addNom(box,"Nom de la classe");
        content.getChildren().add(box);
    }

    private void ajouterType() {
        StackPane type = new StackPane();
        Circle circle = new Circle(10);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(0.2);
        circle.setEffect(new GaussianBlur(2));
        Text text = new Text();
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        String typeClasse = this.type.toLowerCase();
        if (typeClasse.equals("interface")) {
            circle.setFill(Color.BLUEVIOLET);
            text.setText("I");
        } else if (typeClasse.equals("classe")) {
            circle.setFill(Color.GREEN);
            text.setText("C");
        } else if (typeClasse.equals("enum")) {
            circle.setFill(Color.ORANGE);
            text.setText("E");
        } else if (typeClasse.equals("annotation")) {
            circle.setFill(Color.BLUE);
            text.setText("@");
        } else if (typeClasse.equals("abstract class")) {
            circle.setFill(Color.LIGHTGREEN);
            text.setText("A");
        }
        type.getChildren().addAll(circle,text);
        type.setAlignment(Pos.CENTER);
        content.getChildren().add(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void cancelAjout() {
        ajoutElem.getChildren().clear();
    }
}
