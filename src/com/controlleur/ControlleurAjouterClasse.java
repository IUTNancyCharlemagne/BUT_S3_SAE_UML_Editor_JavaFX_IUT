package com.controlleur;

import com.modele.Sujet;
import com.vue.VueAjouterClasse;

import com.vue.VueClasse;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControlleurAjouterClasse implements EventHandler<MouseEvent> {

    private final Sujet modele;
    private VueClasse vueClasse;
    public ControlleurAjouterClasse(Sujet modele) {
        this.modele = modele;
    }
    @Override
    public void handle(MouseEvent event) {
        // Teste si ce qui est cliqué est une image
        if (event.getSource() instanceof ImageView img) {
            // Teste si l'image est celle de l'ajout de classe
            if (img.getId().equals("AjouterAttribut")) {
                vueClasse.ajouterAttribut("Attribut");
            } else if (img.getId().equals("AjouterMethode")) {
                vueClasse.ajouterMethode();
            } else if (img.getId().equals("check")) {
                String titre = vueClasse.getSaisiTitre().getText();
                String accessibilite = vueClasse.getSaisiAccessibilite().getText();
                String type = vueClasse.getSaisiType().getText();
                Boolean etreMethode = vueClasse.getEtreMethode();
                if (!titre.equals("") && accessibilite.equals("") && type.equals("")) {
                    modele.ajouterClasse(titre);
                } else if (!etreMethode) {
                    modele.getClasseCourante().ajouterAttribut(accessibilite + " " + type + " " + titre);
                } else {
                    modele.getClasseCourante().ajouterMethode(accessibilite + " " + type + " " + titre + "()");
                }
                //Clear le Hbox
                VueAjouterClasse.genererPrev();
            }
        }
    }
    public void setVueClasse(VueClasse vue) {
        this.vueClasse = vue;
    }
}
