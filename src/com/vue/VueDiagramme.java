package com.vue;

import com.modele.elements.*;
import javafx.scene.layout.StackPane;
import com.modele.Sujet;

import java.util.ArrayList;
import java.util.List;

public class VueDiagramme extends StackPane implements Observateur {

    private ArrayList<VueClasse> classesList;
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        classesList = new ArrayList<>();
        List<ClasseInterface> classes = sujet.getClasses();

        for (ClasseInterface classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();
            vueElement.setTitle(classe.getNom());

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
            for (Association association : classe.getAssociations()) {

            }

            for (Implementation implementation : classe.getImplementations()) {

            }

            classesList.add(vueElement);
            this.getChildren().add(vueElement);
        }
    }


    public VueDiagramme() {
        super();
        this.setPrefSize(800, 600);
        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
