package com.vue;

import com.modele.Modele;
import com.modele.Sujet;
import com.modele.composite.ArborescenceDossier;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.*;

public class VueArborescence extends TreeView<String> implements Observateur {
    public VueArborescence() {
        super();
        this.setPrefWidth(200);
    }

    @Override
    public void actualiser(Sujet sujet) {
        Modele modele = (Modele) sujet;
        ArborescenceDossier arborescence = modele.getFichiers();
        TreeItem<String> root = new TreeItem<>(arborescence.getNom());
        this.setRoot(root);
        ajouterDossier(arborescence, root);
    }

    public void ajouterDossier(ArborescenceDossier arborescence,TreeItem<String> root) {
        for (ArborescenceDossier dossier : arborescence.getArborescence()) {
            TreeItem<String> treeItem = new TreeItem<>(dossier.getNom());
            root.getChildren().add(treeItem);
            ajouterDossier(dossier,treeItem);
        }
        ajouterFichier(arborescence, root);
    }

    public void ajouterFichier(ArborescenceDossier arborescence, TreeItem<String> root) {
        for (String file : arborescence.getFiles()) {
            TreeItem<String> item2 = new TreeItem<>(file);
            root.getChildren().add(item2);
        }
    }
}
