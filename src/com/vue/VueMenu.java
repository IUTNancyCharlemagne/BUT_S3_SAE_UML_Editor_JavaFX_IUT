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
import java.util.List;

import static com.Main.controlleurMenu;

public class VueMenu extends MenuBar implements Observateur {

    private Modele modele;
    private VueGlobal vue;

    private ArrayList<VueClasse> classesList;

    private ControlleurSouris controlleurSouris;


    public VueMenu(Modele modele, VueGlobal vue) {
        super();
        this.modele = modele;
        this.vue = vue;
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        controlleurSouris = new ControlleurSouris(modele);
        ControlleurMenu controlleurMenu = new ControlleurMenu(modele, vue);
    }

    @Override
    public void actualiser(Sujet sujet) {
        this.getMenus().clear();



        // On crée un bouton pour chaque action

        // On crée un bouton pour ouvrir un repertoire
        Menu ouvrir = new Menu();
        Label ouvrirLabel = new Label("Ouvrir");
        ouvrirLabel.setPrefSize(35, 15);
        ouvrirLabel.setId("btnOuvrir");
        ouvrirLabel.setOnMouseClicked(controlleurSouris);
        ouvrir.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        ouvrir.setGraphic(ouvrirLabel);

        Menu menuClasses = genererMenuClasses();
        Menu menuAttributs = genererMenuAttributs();
        Menu menuMethodes = genererMenuMethodes();
        Menu menuHeritageImplem = genererMenuHeritImplem();
        Menu menuAssos = genererMenuAssos();
        Menu menuExporter = genererMenuExporter();


        // on crée un bouton pour enregistrer le diagramme
        Menu btnEnregistrer = new Menu("Enregistrer");
        btnEnregistrer.setId("btnEnregistrer");

        Menu separator = new Menu("|");
        separator.setDisable(true);

        // On ajoute les boutons à la vue
        this.getMenus().addAll(ouvrir, btnEnregistrer, separator, menuClasses, menuAttributs, menuMethodes, menuHeritageImplem, menuAssos, separator, menuExporter);
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
     * Genere le menu attributs
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
            List<Attribut> attributs = classe.getAttributs();
            if (attributs.isEmpty()) continue;
            MenuItem item = new MenuItem("--- " + classe.getNom() + " ---");
            menuAttributs.getItems().add(item);
            for (Attribut attribut : attributs) {
                if (attribut == null) continue;
                MenuItem subitem = new MenuItem("\t" + attribut.getNom());
                menuAttributs.getItems().add(subitem);
            }
        }
        return menuAttributs;
    }

    private Menu genererMenuMethodes() {
        Menu menuMethodes = new Menu("Méthodes");
        menuMethodes.setId("btnMethodes");
        // > on crée des items pour ajouter une methode et lister les existantes
        MenuItem itemAjouterMethode = new MenuItem("+ Ajouter une méthode");
        itemAjouterMethode.setId("ajouterMethode");
        itemAjouterMethode.setOnAction(controlleurMenu);

        menuMethodes.getItems().add(itemAjouterMethode);

        //Liste les noms des methodes
        if (!modele.getClasses().isEmpty()) menuMethodes.getItems().add(new SeparatorMenuItem());
        for (ClasseInterface classe : modele.getClasses()) {
            if (classe == null) continue;
            List<Methode> methodes = classe.getMethodes();
            if (methodes.isEmpty()) continue;
            MenuItem item = new MenuItem("--- " + classe.getNom() + " ---");
            menuMethodes.getItems().add(item);
            for (Methode methode : methodes) {
                if (methode == null) continue;
                MenuItem subitem = new MenuItem("\t" + methode.getNom());
                menuMethodes.getItems().add(subitem);
            }
        }
        return menuMethodes;
    }

    private Menu genererMenuHeritImplem() {
        Menu menuHeritageImplem = new Menu("Héritages/Implémentations");
        menuHeritageImplem.setId("btnHeritageImplem");
        // > on crée des items pour ajouter un heritage/implem et lister les existantes
        MenuItem itemAjouterHeritageImplem = new MenuItem("+ Ajouter un héritage/implémentation");
        itemAjouterHeritageImplem.setId("ajouterHeritageImplem");
        itemAjouterHeritageImplem.setOnAction(controlleurMenu);

        menuHeritageImplem.getItems().add(itemAjouterHeritageImplem);

        //Liste les noms des heritage/implem
        if (!modele.getClasses().isEmpty()) menuHeritageImplem.getItems().add(new SeparatorMenuItem());
        for (ClasseInterface classe : modele.getClasses()) {
            if (classe == null) continue;
            Heritage heritage = classe.getHeritage();
            List<Implementation> implementations = classe.getImplementations();

            if (heritage == null && implementations.isEmpty()) continue;
            MenuItem item = new MenuItem("--- " + classe.getNom() + " ---");
            menuHeritageImplem.getItems().add(item);
            if (heritage != null) {
                MenuItem subitem = new MenuItem("\t ——▷ " + heritage.getDestinationClasse().getNom());
                menuHeritageImplem.getItems().add(subitem);
            }
            if (implementations.isEmpty()) continue;

            menuHeritageImplem.getItems().add(item);
            for (Implementation implementation : implementations) {
                if (implementation == null) continue;
                MenuItem subitem = new MenuItem("\t --▷ " + implementation.getDestinationClasse().getNom());
                menuHeritageImplem.getItems().add(subitem);
            }
        }
        return menuHeritageImplem;
    }

    public Menu genererMenuAssos()
    {
        Menu menuAssos = new Menu("Associations");
        menuAssos.setId("btnAssos");
        // > on crée des items pour ajouter une association et lister les existantes
        MenuItem itemAjouterAsso = new MenuItem("+ Ajouter une association");
        itemAjouterAsso.setId("ajouterAssos");
        itemAjouterAsso.setOnAction(controlleurMenu);

        menuAssos.getItems().add(itemAjouterAsso);

        //Liste les noms des associations
        if (!modele.getClasses().isEmpty()) menuAssos.getItems().add(new SeparatorMenuItem());
        for (ClasseInterface classe : modele.getClasses()) {
            if (classe == null) continue;
            List<Association> associations = classe.getAssociations();

            if (associations.isEmpty()) continue;
            MenuItem item = new MenuItem("--- " + classe.getNom() + " ---");
            menuAssos.getItems().add(item);

            for (Association association : associations) {
                if (association == null) continue;
                MenuItem subitem = new MenuItem("\t ——> " + association.getNom());
                menuAssos.getItems().add(subitem);
            }
        }
        return menuAssos;
    }

    public Menu genererMenuExporter()
    {
        Menu menuExporter = new Menu("\u2913 Exporter");
        menuExporter.setId("btnExporter");
        // > On crée un bouton pour exporter en image
        MenuItem itemExporterPng = new MenuItem("Image (.png)");
        itemExporterPng.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
        itemExporterPng.setId("btnExpImg");
        itemExporterPng.setOnAction(controlleurMenu);

        // > On crée un bouton pour exporter en PlantUML
        MenuItem itemExporterPuml = new MenuItem("PlantUML (.plantuml)");
        itemExporterPuml.setAccelerator(new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN));
        itemExporterPuml.setId("btnExpPuml");
        itemExporterPuml.setOnAction(controlleurMenu);

        menuExporter.getItems().addAll(itemExporterPng, itemExporterPuml);
        return menuExporter;
    }
}
