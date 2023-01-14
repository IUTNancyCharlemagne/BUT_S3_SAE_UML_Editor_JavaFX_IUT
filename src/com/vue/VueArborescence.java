package com.vue;

import com.Main;
import com.modele.Modele;
import com.modele.Sujet;
import com.modele.composite.ArborescenceDossier;
import javafx.application.Platform;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;

import java.util.*;

import static com.Main.controllerDeplacerClasse;
import static com.Main.controlleurGlisserDeposer;

public class VueArborescence extends TreeView<Text> implements Observateur {
    public VueArborescence() {
        super();
        this.setPrefWidth(200);
    }

    @Override
    public void actualiser(Sujet sujet) {
        Modele modele = (Modele) sujet;
        ArborescenceDossier arborescence = modele.getFichiers();
        TreeItem<Text> root = new TreeItem<>(new Text(arborescence.getNom()));
        root.setExpanded(true);
        this.setRoot(root);
        ajouterDossier(arborescence, root);
    }

    public void ajouterDossier(ArborescenceDossier arborescence,TreeItem<Text> root) {
        for (ArborescenceDossier dossier : arborescence.getArborescence()) {
            Text nomDossier = new Text(dossier.getNom());
            TreeItem<Text> treeItem = new TreeItem<>(nomDossier);
            root.getChildren().add(treeItem);
            ajouterDossier(dossier,treeItem);
        }
        ajouterFichier(arborescence, root);
    }

    public void ajouterFichier(ArborescenceDossier arborescence, TreeItem<Text> root) {
        for (List<String> file : arborescence.getFiles()) {
            TreeItem<Text> item2 = new TreeItem<>(new Text());
            item2.setGraphic(new Text(file.get(0)));
            item2.getGraphic().setOnDragDetected(controllerDeplacerClasse);
            root.getChildren().add(item2);
        }
    }
}
