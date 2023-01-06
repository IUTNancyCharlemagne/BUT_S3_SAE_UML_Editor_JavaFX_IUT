package com.vue;

import com.controlleur.ControlleurBoutton;
import com.modele.Modele;
import com.modele.Sujet;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VueMenu extends HBox implements Observateur {

    private Modele modele;

    public VueMenu(Modele modele) {
        super();
        this.modele = modele;
        this.setSpacing(10);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

    @Override
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        ControlleurBoutton controlleurBoutton = new ControlleurBoutton(modele);
        // On crée un bouton pour chaque action
        // On crée un bouton pour ouvrir un repertoire
        Button btnOuvrir = new Button("Ouvrir");
        btnOuvrir.setId("btnOuvrir");
        btnOuvrir.setOnAction(controlleurBoutton);

        // on crée un bouton pour ajouter une classe
        Button btnAjouterClasse = new Button("Ajouter");
        btnAjouterClasse.setId("btnAjouterClasse");

        // on crée un bouton pour lister les classes existantes
        Button btnListerClasses = new Button("Classes");
        btnListerClasses.setId("btnListerClasses");

        // on crée un bouton pour lister les attributs d'une classe
        Button btnListerAttributs = new Button("Attributs");
        btnListerAttributs.setId("btnListerAttributs");

        // on crée un bouton pour lister les methodes d'une classe
        Button btnListerMethodes = new Button("Méthodes");
        btnListerMethodes.setId("btnListerMethodes");

        // on crée un bouton pour lister les héritages et implementations d'une classe
        Button btnListerHeritage = new Button("Héritage");
        btnListerHeritage.setId("btnListerHeritage");

        // on crée un bouton pour lister les associations d'une classe
        Button btnListerAssociation = new Button("Association");
        btnListerAssociation.setId("btnListerAssociation");

        // on crée un bouton pour exporter le diagramme
        Button btnListerDependance = new Button("Exporter");
        btnListerDependance.setId("btnExporter");

        // on crée un bouton pour enregistrer le diagramme
        Button btnEnregistrer = new Button("Enregistrer");
        btnEnregistrer.setId("btnEnregistrer");

        // On ajoute les boutons à la vue
        this.getChildren().addAll(btnOuvrir, btnAjouterClasse, btnListerClasses,
                btnListerAttributs, btnListerMethodes, btnListerHeritage,
                btnListerAssociation, btnListerDependance, btnEnregistrer);
    }
}
