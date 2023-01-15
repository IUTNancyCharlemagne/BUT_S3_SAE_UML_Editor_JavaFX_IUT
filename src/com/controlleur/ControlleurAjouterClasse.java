package com.controlleur;

import com.modele.Sujet;
import com.modele.elements.Attribut;
import com.modele.elements.Methode;
import com.vue.VueAjouterClasse;

import com.vue.Fabrique.elements.VueClasse;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.List;

public class ControlleurAjouterClasse implements EventHandler<MouseEvent> {

    private final Sujet modele;
    private VueClasse vueClasse;
    private TextField paramatreMethode;

    public ControlleurAjouterClasse(Sujet modele) {
        this.modele = modele;
        paramatreMethode = new TextField();
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() instanceof StackPane p) {
            if (p.getId().equals("AjouterAttribut")) {
                vueClasse.ajouterAttribut("Attribut");
            } else if (p.getId().equals("AjouterMethode")) {
                vueClasse.ajouterMethode();
            }else if (p.getId().equals("AjouterParametre")) {
                ImageView l = (ImageView) p.getChildren().get(0);
                paramatreMethode = vueClasse.ajouterParametre(l.getId());
            }
        }
        // Teste si ce qui est cliqué est une image
        else if (event.getSource() instanceof ImageView img) {
            // Teste si l'image est celle de l'ajout de classe
            if (img.getId().equals("check")) {
                String titre = vueClasse.getSaisiTitre();
                String accessibilite = vueClasse.getSaisiAccessibilite();
                String type = vueClasse.getSaisiType();
                Boolean etreMethode = vueClasse.getEtreMethode();
                if (!titre.equals("") && accessibilite.equals("") && !type.equals("")) {
                    modele.ajouterClasse(titre);
                    modele.getClasseCourante().setType(type);
                } else if (!etreMethode && !accessibilite.equals("")) {
                    modele.getClasseCourante().ajouterAttribut(accessibilite + " " + type + " " + titre);
                } else if (etreMethode) {
                    modele.getClasseCourante().ajouterMethode(accessibilite + " " + type + " " + titre + "()");
                } else {
                    vueClasse.cancelAjout();
                }
            }else if(img.getId().contains("checkParam")) {
                Methode methode = modele.getClasseCourante().getMethode(img.getId().substring(11));
                Attribut parametre = new Attribut("",paramatreMethode.getText(),"","");

                List<Attribut> a = methode.getParametres();
                a.add(parametre);
                for (Attribut attribut : a) {
                    System.out.println(attribut.getType());
                }
                modele.getClasseCourante().modifierMethode(methode, methode.getVisibilite() , methode.getType() , methode.getNom() , a);
            }
            VueAjouterClasse.genererPrev();
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
