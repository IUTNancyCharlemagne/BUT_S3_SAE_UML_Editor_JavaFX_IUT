package com.vue;

import com.modele.Sujet;
import com.modele.elements.*;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;

public class VueFrabriqueClasses extends FlowPane {

    private ArrayList<VueClasse> classesList;

    public void generer(Sujet sujet) {
        classesList = new ArrayList<>();
        List<ClasseInterface> classes = sujet.getClasses();
        this.getChildren().clear();
        this.setPrefSize(800,600);
        for (ClasseInterface classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            Group classeVue = new Group();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();

            vueElement.setPrefSize(200, 200);
            vueElement.setTitle(classe.getNom());
            vueElement.ajouterSeparateur();

            for (Attribut attribut : classe.getAttributs()) {
                fabriqueDeVue = new FabriqueVueAttribut();

                VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();

                vueAttribut.setAccessibility(attribut.getVisibilite());
                vueAttribut.setType(attribut.getType());
                vueAttribut.setName(attribut.getNom());

                vueElement.setAttribut(vueAttribut);
            }
            vueElement.ajouterSeparateur();
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
            classeVue.getChildren().add(vueElement);
            classesList.add(vueElement);
            this.getChildren().add(classeVue);
        }
    }
}
