package com.controlleur;

import com.modele.Sujet;
import com.vue.VueContenuAjouterClasse;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ControlleurAjouterClasse implements EventHandler<MouseEvent> {

    private final Sujet modele;
    private final VueContenuAjouterClasse vueContenuAjouterClasse;
    public ControlleurAjouterClasse(Sujet modele, VueContenuAjouterClasse vueContenuAjouterClasse) {
        this.modele = modele;
        this.vueContenuAjouterClasse = vueContenuAjouterClasse;
    }
    @Override
    public void handle(MouseEvent event) {
        //VueClasse vueClasse = vueAjouterClasse.getVueClasse();
        if (event.getSource() instanceof ImageView img) {
            if (img.getId().equals("AjouterAttribut")) {
                vueContenuAjouterClasse.ajouterAttribut();
            } else if (img.getId().equals("AjouterMethode")) {
                vueContenuAjouterClasse.ajouterMethode();
            } else
                if (img.getId().equals("check")) {
                    String titre = vueContenuAjouterClasse.getSaisiTitre().getText();
                    String accessibilite = vueContenuAjouterClasse.getSaisiAccessibilite().getText();
                    String type = vueContenuAjouterClasse.getSaisiType().getText();
                    if (!titre.equals("") && accessibilite.equals("") && type.equals("")) {
                        modele.ajouterClasse(titre);
                    } else {
                        modele.getClasseCourante().ajouterAttribut(accessibilite + " " + type + " " + titre);
                    }
                    vueContenuAjouterClasse.getHbox().getChildren().clear();
                    vueContenuAjouterClasse.genererPrev();
                    vueContenuAjouterClasse.ajouterMethode();
                }
        }
    }
}
