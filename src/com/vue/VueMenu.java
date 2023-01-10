package com.vue;

import com.controlleur.ControlleurMenu;
import com.controlleur.ControlleurSouris;
import com.modele.Modele;
import com.modele.Sujet;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static com.Main.controlleurMenu;
import static com.Main.controlleurSouris;

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
        ControlleurSouris controlleurSouris = new ControlleurSouris(modele, vue);
        // On crée un bouton pour chaque action
        // On crée un bouton pour ouvrir un repertoire
        Menu ouvrir = new Menu();
        Label ouvrirLabel = new Label("Ouvrir");
        ouvrirLabel.setId("btnOuvrir");
        ouvrirLabel.setOnMouseClicked(controlleurSouris);
        ouvrir.setGraphic(ouvrirLabel);

        // on crée un bouton pour ajouter une classe
        Menu menuAjouter = new Menu("Ajouter");
        menuAjouter.setId("btnAjouter");

        // on crée des items pour ajouter des elements
        MenuItem itemAjouterClasse = new MenuItem("Ajouter classe");
        itemAjouterClasse.setId("ajouterClasseJava");
        itemAjouterClasse.setOnAction(controlleurMenu);

        menuAjouter.getItems().add(itemAjouterClasse);

        // on crée un bouton pour lister les classes existantes
        Menu btnListerClasses = new Menu("Classes");
        btnListerClasses.setId("btnListerClasses");

        // on crée un bouton pour lister les attributs d'une classe
        Menu btnListerAttributs = new Menu("Attributs");
        btnListerAttributs.setId("btnListerAttributs");

        // on crée un bouton pour lister les methodes d'une classe
        Menu btnListerMethodes = new Menu("Méthodes");
        btnListerMethodes.setId("btnListerMethodes");

        // on crée un bouton pour lister les héritages et implementations d'une classe
        Menu btnListerHeritage = new Menu("Héritage");
        btnListerHeritage.setId("btnListerHeritage");

        // on crée un bouton pour lister les associations d'une classe
        Menu btnListerAssociation = new Menu("Association");
        btnListerAssociation.setId("btnListerAssociation");

        // on crée un bouton pour exporter le diagramme
        Menu btnListerExporter = new Menu("Exporter");
        btnListerExporter.setId("btnExporter");

        // > On crée un bouton pour exporter en image
        Label btnExpImg = new Label("Image (.png)");
        btnExpImg.setTextFill(Color.web("#0076a3"));
        MenuItem expImg = new MenuItem("Image (.png)");
        expImg.setGraphic(btnExpImg);
        btnExpImg.setId("btnExpImg");
        //expImg.setOnMouseClicked(controlleurBoutton);

        btnListerExporter.getItems().add(expImg);

        // on crée un bouton pour enregistrer le diagramme
        Menu btnEnregistrer = new Menu("Enregistrer");
        btnEnregistrer.setId("btnEnregistrer");

        // On ajoute les boutons à la vue
        this.getMenus().addAll(ouvrir ,menuAjouter, btnListerClasses, btnListerAttributs, btnListerMethodes, btnListerHeritage, btnListerAssociation, btnEnregistrer);
    }
}
