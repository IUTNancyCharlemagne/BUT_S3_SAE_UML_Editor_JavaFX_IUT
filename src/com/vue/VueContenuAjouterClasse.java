package com.vue;

import com.controlleur.ControlleurAjouterClasse;
import com.modele.Sujet;
import com.modele.elements.ClasseInterface;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Collections;

public class VueContenuAjouterClasse extends ScrollPane {

    private FlowPane flowPane;
    private Sujet modele;
    private HBox hbox;
    private TextField saisiTitre;
    private TextField saisiAccessibilite;
    private TextField saisiType;
    private VueClasse vueClasse;


    public VueContenuAjouterClasse(Sujet modele) {
        this.modele = modele;
        flowPane = new FlowPane();
        saisiTitre = new TextField("");
        saisiAccessibilite = new TextField("");
        saisiType = new TextField("");
        hbox = new HBox();
        this.setPrefSize(500, 300);
        flowPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0);" +
                "-fx-padding: 0 0 0 10;");
        flowPane.setAlignment(Pos.CENTER);
    }

    public void generer() {
        // Exemple de visualisation
        addTitre();
        this.flowPane.getChildren().addAll(vueClasse,hbox);
        this.setContent(this.flowPane);
    }

    private void addTitre() {
        addNom("Nom de la classe");
    }

    /**
     * Ajoute un titre à la future classe
     */
    private void addNom(String nom) {
        ControlleurAjouterClasse controlleurAjouterClasse = new ControlleurAjouterClasse(modele,this);
        // Ajout du titre
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: transparent;");

        this.saisiTitre = this.textfield(nom);

        ImageView imageView = image("check.png");
        imageView.setId("check");
        imageView.setOnMouseClicked(controlleurAjouterClasse);


        // On ajoute tous les éléments aux la vue
        hbox.getChildren().addAll(saisiTitre,imageView);
    }

    public void ajouterAttribut() {
        // Ajout des attributs
        hbox.getChildren().clear();
        this.saisiAccessibilite = this.textfield("Accessibilité");
        this.saisiType = this.textfield("Type");
        hbox.getChildren().addAll(saisiAccessibilite, saisiType);
        addNom("Attribut");
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

    public TextField getSaisiTitre() {
        return saisiTitre;
    }

    public TextField getSaisiType() {
        return saisiType;
    }

    public TextField getSaisiAccessibilite() {
        return saisiAccessibilite;
    }

    public HBox getHbox() {
        return hbox;
    }

    public void ajouterMethode() {

    }

    public void genererPrev() {
        this.flowPane.getChildren().remove(vueClasse);
        ClasseInterface classeCourante = modele.getClasseCourante();
        if (classeCourante == null) {
            vueClasse = new VueClasse();
            vueClasse.setTitle("Nom de la classe");
        }
        ControlleurAjouterClasse controlleurAjouterClasse = new ControlleurAjouterClasse(modele,this);
        VueFabriqueClasses fabriqueClasses = new VueFabriqueClasses();
        fabriqueClasses.generer(modele, Collections.singletonList(classeCourante));
        if (classeCourante != null) {
            vueClasse = fabriqueClasses.getClassesList().get(0);
            for (ImageView img : fabriqueClasses.getClassesList().get(0).getImageView()) {
                img.setOnMouseClicked(controlleurAjouterClasse);
            }
            this.flowPane.getChildren().add(vueClasse);
        }
        this.setContent(this.flowPane);
    }
}
