package com.vue;

import com.modele.Modele;
import com.modele.Sujet;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class VueArborescence extends TreeView<String> implements Observateur {
    public VueArborescence() {
        super();
    }

    @Override
    public void actualiser(Sujet sujet) {
        Modele modele = (Modele) sujet;
        String arborescence = modele.getFichiers();
        String[] dossiers = arborescence.split("\\t");
        TreeItem<String> root;
        if (dossiers.length > 1) {
            root = new TreeItem<>(dossiers[0]);
            this.setRoot(root);
            for (int i = 1; i < dossiers.length; i++) {
                String[] fichiers = dossiers[i].split("\\+");
                System.out.println(Arrays.toString(fichiers));
                TreeItem<String> treeItem;
                if (fichiers.length == 1) {
                    treeItem = new TreeItem<>(dossiers[i]);
                    root.getChildren().add(treeItem);
                    root = treeItem;
                } else {
                    treeItem = new TreeItem<>(fichiers[0]);
                    recupererFichiers(treeItem, fichiers);
                    root.getChildren().add(treeItem);
                }
            }
        }else {
            String[] fichiers = dossiers[0].split("\\+");
            root = new TreeItem<>(fichiers[0]);
            this.setRoot(root);
            recupererFichiers(root, fichiers);
        }
    }


    private void recupererFichiers(TreeItem<String> ti, String[] fichiers) {
        for (int j = 1; j < fichiers.length; j++) {
            TreeItem<String> treeItem1 = new TreeItem<>(fichiers[j]);
            ti.getChildren().add(treeItem1);
        }
    }
}
