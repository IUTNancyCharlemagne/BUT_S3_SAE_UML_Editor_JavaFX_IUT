package com.vue;

import javafx.scene.layout.StackPane;
import com.model.Sujet;

import java.util.ArrayList;

public class VueDiagramme extends StackPane implements Observateur {

    private ArrayList<VueClasse> classes;
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        //ArrayList<Classe> classes = sujet.getClasses();

        //for (Classe classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();
            vueElement.setTitle("Classe");
            fabriqueDeVue = new FabriqueVueAttribut();
            VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();
        vueAttribut.setAccessibility("public");
        vueAttribut.setType("int");
        vueAttribut.setName("attribut");
            vueElement.setAttribut(vueAttribut);
            fabriqueDeVue = new FabriqueVueMethode();
            VueElementClasse vueMethode = (VueElementClasse) fabriqueDeVue.creerVueElement();
        vueMethode.setAccessibility("public");
        vueMethode.setType("int");
        vueMethode.setName("attribut");
        vueMethode.setParameters(new String[]{"(String, ", "int)"});
            vueElement.setMethode(vueMethode);
        /**
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
             */
            this.getChildren().add(vueElement);
        //}

    }

    public VueDiagramme() {
        super();
        this.setPrefSize(800, 600);
        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
