package com.controlleur;

import com.modele.Sujet;
import com.vue.VueAjouterClasse;

import com.vue.VueClasse;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ControlleurAjouterClasse implements EventHandler<MouseEvent> {

    private final Sujet modele;
    private VueClasse vueClasse;
    public ControlleurAjouterClasse(Sujet modele) {
        this.modele = modele;
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof StackPane p) {
            if (p.getId().equals("AjouterAttribut")) {
                vueClasse.ajouterAttribut("Attribut");
            } else if (p.getId().equals("AjouterMethode")) {
                vueClasse.ajouterMethode();
            }
        }
        // Teste si ce qui est cliqué est une image
        else if (event.getSource() instanceof ImageView img) {
            // Teste si l'image est celle de l'ajout de classe
            if (img.getId().equals("check")) {
                String titre = vueClasse.getSaisiTitre().getText();
                String accessibilite = vueClasse.getSaisiAccessibilite().getText();
                String type = vueClasse.getSaisiType().getText();
                Boolean etreMethode = vueClasse.getEtreMethode();
                if (!titre.equals("") && accessibilite.equals("") && !type.equals("")) {
                    modele.ajouterClasse(titre);
                    modele.getClasseCourante().setType(type);
                } else if (!etreMethode && !accessibilite.equals("")) {
                    modele.getClasseCourante().ajouterAttribut(accessibilite + " " + type + " " + titre);
                } else if (etreMethode && !accessibilite.equals("")) {
                    modele.getClasseCourante().ajouterMethode(accessibilite + " " + type + " " + titre + "()");
                } else {
                    vueClasse.cancelAjout();
                }
                VueAjouterClasse.genererPrev();
            }
        }
        // Teste si ce qui est cliqué est un bouton
        else if (event.getSource() instanceof Button b) {
            if (b.getId().equals("ajouterClasseDiag")) {
                modele.ajouterClasseDiagramme();
                modele.notifierObservateurs();
                modele.retirerClasseCourante();
                VueAjouterClasse.genererPrev();
            } else if (b.getId().equals("cancel")) {
                modele.retirerClasseCourante();
                VueAjouterClasse.genererPrev();
            }
        }
    }
    public void setVueClasse(VueClasse vue) {
        this.vueClasse = vue;
    }
}
