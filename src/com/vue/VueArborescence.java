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
        System.out.println(Arrays.toString(dossiers));
        TreeItem<String> root = new TreeItem<>(dossiers[0]);
        for (int i = 1; i < dossiers.length; i++) {
            String[] fichiers = dossiers[i].split("\\+");
            TreeItem<String> treeItem;
            if (fichiers.length == 0){
               treeItem = new TreeItem<>(dossiers[i]);
            }
            else {
                treeItem = new TreeItem<>(fichiers[0]);
                for (int j = 1; j < fichiers.length; j++) {
                    TreeItem<String> treeItem1 = new TreeItem<>(fichiers[j]);
                    treeItem.getChildren().add(treeItem1);
                }
            }
            root.getChildren().add(treeItem);
        }
        this.setRoot(root);
    }

}
