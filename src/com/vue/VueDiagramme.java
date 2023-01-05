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
        System.out.println("VueDiagramme: " + classes.size());
        for (ClasseInterface classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();
            vueElement.setTitle(classe.getNom());

            for (Attribut attribut : classe.getAttributs()) {
                fabriqueDeVue = new FabriqueVueAttribut();

                VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();

                vueAttribut.setAccessibility(attribut.getVisibilite());
                vueAttribut.setType(attribut.getType());
                vueAttribut.setName(attribut.getNom());

                vueElement.setAttribut(vueAttribut);
            }
            for (Methode methode : classe.getMethodes()) {
                fabriqueDeVue = new FabriqueVueMethode();

                VueElementClasse vueMethode = (VueElementClasse) fabriqueDeVue.creerVueElement();

                vueMethode.setAccessibility(methode.getVisibilite());
                vueMethode.setType(methode.getType());
                vueMethode.setName(methode.getNom());
                vueMethode.setParameters(methode.getParametres());

                vueElement.setMethode(vueMethode);
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
