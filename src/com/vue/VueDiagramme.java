package com.vue;

import com.modele.elements.ClasseInterface;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import com.modele.Sujet;

import java.util.ArrayList;

public class VueDiagramme extends Pane implements Observateur {

    private ArrayList<VueClasse> classes;
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        //ArrayList<Classe> classes = sujet.getClasses();

        //for (Classe classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            VueClasse vueClasse = (VueClasse) fabriqueDeVue.creerVueElement();
            vueClasse.setTitle("Classe");
            vueClasse.setPos(100, 50);
            StackPane test = new StackPane();
            fabriqueDeVue = new FabriqueVueAttribut();
            VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();
        vueAttribut.setAccessibility("public");
        vueAttribut.setType("int");
        vueAttribut.setName("attribut");
            vueClasse.setAttribut(vueAttribut);
            fabriqueDeVue = new FabriqueVueMethode();
            VueElementClasse vueMethode = (VueElementClasse) fabriqueDeVue.creerVueElement();
        vueMethode.setAccessibility("public");
        vueMethode.setType("int");
        vueMethode.setName("attribut");
        vueMethode.setParameters(new String[]{"(String, ", "int)"});
            vueClasse.setMethode(vueMethode);
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
            this.getChildren().add(vueClasse);
        //}

    }

    public VueDiagramme() {
        super();
        this.setPrefSize(800, 600);
        this.setStyle("-fx-background-color: #FFFFFF");
    }

    /*
    public void positionnerClasses()
    {
        int count = 0;
        for (VueClasse classe : classes)
        {
            classe.setPos();
        }
    }
         */
}
