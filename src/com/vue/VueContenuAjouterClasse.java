package com.vue;

import com.modele.Sujet;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class VueContenuAjouterClasse extends ScrollPane {

    private FlowPane flowPane;
    private Sujet modele;


    private VueClasse vueClasse;


    public VueContenuAjouterClasse(Sujet modele) {
        this.modele = modele;
        flowPane = new FlowPane();
        this.setPrefSize(500, 300);
        flowPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0);" +
                "-fx-padding: 0 0 0 10;");
        flowPane.setAlignment(Pos.CENTER);
    }

    public void generer() {
        // Exemple de visualisation
        addTitre();
        this.flowPane.getChildren().addAll(vueClasse);
        this.setContent(this.flowPane);
    }

    public void addTitre() {

    }



    /**
     * Ajoute un titre à la future classe
     */






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
