package com.vue;

import com.modele.Sujet;
import com.modele.elements.*;
import javafx.scene.Group;

import javafx.scene.layout.AnchorPane;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Transform;
import java.util.ArrayList;
import java.util.List;
public class VueFabriqueClasses extends AnchorPane {
    private ArrayList<VueClasse> classesList;

    public void generer(Sujet sujet, List<ClasseInterface> classes) {
        classesList = new ArrayList<>();
        this.getChildren().clear();
        this.setPrefSize(800, 600);
        for (ClasseInterface classe : classes) {
            if (classe == null) continue;
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            Group classeVue = new Group();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();

            vueElement.setTitle(classe.getNom());
            vueElement.ajouterSeparateur();
            if (sujet.getClasseCourante() != null) {
                vueElement.imageAdd("AjouterAttribut");
            }
            for (Attribut attribut : classe.getAttributs()) {
                fabriqueDeVue = new FabriqueVueAttribut();

                VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();

                vueAttribut.setAccessibility(attribut.getVisibilite());
                vueAttribut.setType(attribut.getType());
                vueAttribut.setName(attribut.getNom());

                vueElement.setAttribut(vueAttribut);
            }

            vueElement.ajouterSeparateur();
            if (sujet.getClasseCourante() != null) {
                vueElement.imageAdd("AjouterMethode");
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
            classeVue.getChildren().add(vueElement);
            classesList.add(vueElement);
            this.getChildren().add(classeVue);
        }

    }

    public ArrayList<VueClasse> getClassesList() {
        return classesList;
    }


    public WritableImage exportImage() {
        SnapshotParameters spa = new SnapshotParameters();
        spa.setTransform(Transform.scale(3, 3));
        return this.snapshot(spa, null);
    }

}
