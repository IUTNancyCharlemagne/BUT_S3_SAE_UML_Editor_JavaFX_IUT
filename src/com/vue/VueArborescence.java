package com.vue;

import com.modele.Modele;
import com.modele.Sujet;
import com.modele.composite.ArborescenceDossier;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;

import java.util.*;

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
        this.setRoot(root);
        ajouterDossier(arborescence, root);
    }

    public void ajouterDossier(ArborescenceDossier arborescence,TreeItem<Text> root) {
        for (ArborescenceDossier dossier : arborescence.getArborescence()) {
            TreeItem<Text> treeItem = new TreeItem<>(new Text(dossier.getNom()));
            root.getChildren().add(treeItem);
            ajouterDossier(dossier,treeItem);
        }
        ajouterFichier(arborescence, root);
    }

    public void ajouterFichier(ArborescenceDossier arborescence, TreeItem<Text> root) {
        for (String file : arborescence.getFiles()) {
            TreeItem<Text> item2 = new TreeItem<>(new Text(file));
            root.getChildren().add(item2);
        }
    }
}
