package com.vue;

import com.controlleur.ControlleurMenu;
import com.controlleur.ControlleurSouris;
import com.modele.Modele;
import com.modele.Sujet;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VueMenu extends MenuBar implements Observateur {

    private Modele modele;
    private VueGlobal vue;

    public VueMenu(Modele modele, VueGlobal vue) {
        super();
        this.modele = modele;
        this.vue = vue;
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

    @Override
    public void actualiser(Sujet sujet) {
        this.getMenus().clear();
        ControlleurSouris controlleurSouris = new ControlleurSouris(modele);
        ControlleurMenu controlleurMenu = new ControlleurMenu(modele, vue);

        //SeparatorMenuItem sep = new SeparatorMenuItem();
        // On crée un bouton pour chaque action
        // On crée un bouton pour ouvrir un repertoire
        Menu ouvrir = new Menu();
        Label ouvrirLabel = new Label("Ouvrir");
        ouvrirLabel.setId("btnOuvrir");
        ouvrirLabel.setOnMouseClicked(controlleurSouris);
        ouvrir.setGraphic(ouvrirLabel);

        // on crée un menu classes
        Menu menuClasses = new Menu("Classes");
        menuClasses.setId("btnClasses");
        // > on crée des items pour ajouter une classe et lister les existantes
        MenuItem itemAjouterClasse = new MenuItem("+ Ajouter une classe");
        itemAjouterClasse.setId("ajouterClasseJava");
        itemAjouterClasse.setOnAction(controlleurMenu);

        menuClasses.getItems().addAll(itemAjouterClasse, new SeparatorMenuItem());


        // on crée un menu attributs
        Menu menuAttributs = new Menu("Attributs");
        menuAttributs.setId("btnAttributs");
        // > on crée des items pour ajouter un attribut et lister les existantes
        MenuItem itemAjouterAttribut = new MenuItem("+ Ajouter un attribut");
        itemAjouterAttribut.setId("ajouterAttribut");
        itemAjouterAttribut.setOnAction(controlleurMenu);

        menuAttributs.getItems().addAll(itemAjouterAttribut, new SeparatorMenuItem());


        // on crée un menu methodes
        Menu menuMethodes = new Menu("Méthodes");
        menuMethodes.setId("btnMethodes");
        // > on crée des items pour ajouter une methode et lister les existantes
        MenuItem itemAjouterMethode = new MenuItem("+ Ajouter une méthode");
        itemAjouterMethode.setId("ajouterMethode");
        itemAjouterMethode.setOnAction(controlleurMenu);

        menuMethodes.getItems().addAll(itemAjouterMethode, new SeparatorMenuItem());

        // on crée un menu héritage/implementation
        Menu menuHeritageImplem = new Menu("Héritages/Implémentations");
        menuHeritageImplem.setId("btnHeritageImplem");
        // > on crée des items pour ajouter une methode et lister les existantes
        MenuItem itemAjouterHeritageImplem = new MenuItem("+ Ajouter un héritage/implémentation");
        itemAjouterHeritageImplem.setId("ajouterHeritageImplem");
        itemAjouterHeritageImplem.setOnAction(controlleurMenu);

        menuHeritageImplem.getItems().addAll(itemAjouterHeritageImplem, new SeparatorMenuItem());


        // on crée un bouton pour lister les héritages et implementations d'une classe
        Menu btnListerHeritage = new Menu("Héritage");
        btnListerHeritage.setId("btnListerHeritage");

        // on crée un bouton pour lister les associations d'une classe
        Menu btnListerAssociation = new Menu("Association");
        btnListerAssociation.setId("btnListerAssociation");


        // on crée un menu pour exporter
        Menu menuExporter = new Menu("\u2913 Exporter");
        menuExporter.setId("btnExporter");

        // > On crée un bouton pour exporter en image
        MenuItem itemExporterPng = new MenuItem("Image (.png)");
        itemExporterPng.setId("btnExpImg");
        itemExporterPng.setOnAction(controlleurMenu);

        menuExporter.getItems().add(itemExporterPng);



        // on crée un bouton pour enregistrer le diagramme
        Menu btnEnregistrer = new Menu("Enregistrer");
        btnEnregistrer.setId("btnEnregistrer");

        // On ajoute les boutons à la vue
        this.getMenus().addAll(ouvrir, btnEnregistrer, new Menu("|"), menuClasses, menuAttributs, menuMethodes, menuHeritageImplem, btnListerAssociation, new Menu("|"), menuExporter);
    }
}
