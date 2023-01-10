package com.vue;

import com.controlleur.ControlleurMenu;
import com.controlleur.ControlleurSouris;
import com.modele.Modele;
import com.modele.Sujet;
import com.modele.elements.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static com.Main.controlleurMenu;

public class VueMenu extends MenuBar implements Observateur {

    private Modele modele;
    private VueGlobal vue;

    private ArrayList<VueClasse> classesList;


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


        // On crée un bouton pour chaque action
        // On crée un bouton pour ouvrir un repertoire
        Menu ouvrir = new Menu();
        Label ouvrirLabel = new Label("Ouvrir");
        ouvrirLabel.setId("btnOuvrir");
        ouvrirLabel.setOnMouseClicked(controlleurSouris);
        ouvrir.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        ouvrir.setGraphic(ouvrirLabel);

        Menu menuClasses = genererMenuClasses();
        Menu menuAttributs = genererMenuAttributs();


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


        // on crée un menu associations
        Menu menuAssos = new Menu("Associations");
        menuAssos.setId("btnAssos");
        // > on crée des items pour ajouter une methode et lister les existantes
        MenuItem itemAjouterAsso = new MenuItem("+ Ajouter une association");
        itemAjouterAsso.setId("ajouterAssos");
        itemAjouterAsso.setOnAction(controlleurMenu);

        menuAssos.getItems().addAll(itemAjouterAsso, new SeparatorMenuItem());


        // on crée un menu pour exporter
        Menu menuExporter = new Menu("\u2913 Exporter");
        menuExporter.setId("btnExporter");
        // > On crée un bouton pour exporter en image
        MenuItem itemExporterPng = new MenuItem("Image (.png)");
        itemExporterPng.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
        itemExporterPng.setId("btnExpImg");
        itemExporterPng.setOnAction(controlleurMenu);

        menuExporter.getItems().add(itemExporterPng);


        // on crée un bouton pour enregistrer le diagramme
        Menu btnEnregistrer = new Menu("Enregistrer");
        btnEnregistrer.setId("btnEnregistrer");

        // On ajoute les boutons à la vue
        this.getMenus().addAll(ouvrir, btnEnregistrer, new Menu("|"), menuClasses, menuAttributs, menuMethodes, menuHeritageImplem, menuAssos, new Menu("|"), menuExporter);
    }

    /**
     * Genere le menu classe
     * @return Menu
     */
    private Menu genererMenuClasses() {
        Menu menuClasses = new Menu("Classes");
        menuClasses.setId("btnClasses");

        // > on crée des items pour ajouter une classe et lister les existantes
        MenuItem itemAjouterClasse = new MenuItem("+ Ajouter une classe");
        itemAjouterClasse.setId("ajouterClasseJava");
        itemAjouterClasse.setOnAction(controlleurMenu);
        itemAjouterClasse.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        menuClasses.getItems().add(itemAjouterClasse);
        //menuClasses.setStyle("-fx-height: 1px;");

        //Liste les noms des classes
        if (!modele.getClasses().isEmpty())
            menuClasses.getItems().add(new SeparatorMenuItem());

        for (ClasseInterface classe : modele.getClasses()) {
            if (classe == null) continue;
            MenuItem item = new MenuItem(classe.getNom());
            menuClasses.getItems().add(item);
        }
        return menuClasses;
    }

    /**
     * Genere le menu classe
     * @return Menu
     */
    private Menu genererMenuAttributs() {
        Menu menuAttributs = new Menu("Attributs");
        menuAttributs.setId("btnAttributs");
        // > on crée des items pour ajouter un attribut et lister les existantes
        MenuItem itemAjouterAttribut = new MenuItem("+ Ajouter un attribut");
        itemAjouterAttribut.setId("ajouterAttribut");
        itemAjouterAttribut.setOnAction(controlleurMenu);

        menuAttributs.getItems().add(itemAjouterAttribut);

        //Liste les noms des classes
        if (!modele.getClasses().isEmpty()) menuAttributs.getItems().add(new SeparatorMenuItem());
        for (ClasseInterface classe : modele.getClasses()) {
            if (classe == null) continue;
            MenuItem item = new MenuItem("---" + classe.getNom() + "---");
            menuAttributs.getItems().add(item);
            /*for (Attribut attribut : modele.getClasseCourante().getAttributs()) {
                if (attribut == null) continue;
                MenuItem subitem = new MenuItem(attribut.getNom());
                menuAttributs.getItems().add(subitem);
            }*/
        }
        return menuAttributs;
    }
}
