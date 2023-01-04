package com.vue;

import com.modele.elements.Classe;
import com.modele.elements.Element;
import javafx.scene.layout.StackPane;
import com.modele.Sujet;

import java.util.ArrayList;

public class VueDiagramme extends StackPane implements Observateur {

    private ArrayList<VueClasse> classes;
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        ArrayList<Element> classes = sujet.getElements();

        for (Classe classe : classes) {

            for (Attribut attribut : classe.getAttributs()) {
                fabriqueDeVue = new FabriqueVueAttribut();
                VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();
                vueElement.setAttribut(vueAttribut);
            }
            for (Methode methode : classe.getMethodes()) {
                fabriqueDeVue = new FabriqueVueMethode();
                VueElementClasse vueElementClasse = (VueElementClasse) fabriqueDeVue.creerVueElement();
                vueElement.setMethode(vueElementClasse);
            }

            this.getChildren().add(vueElement);
            //}
        }
    }


    public VueDiagramme() {
        super();
        this.setPrefSize(800, 600);
        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
