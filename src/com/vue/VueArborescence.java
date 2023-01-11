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
        /**String[] dossiers = arborescence.split("\\t");
        TreeItem<String> root;
        if (dossiers.length > 1) {
            root = new TreeItem<>(dossiers[0]);
            this.setRoot(root);
            for (int i = 1; i < dossiers.length; i++) {
                String[] fichiers0 = dossiers[i].split("SEPARATEUR");
                System.out.println(Arrays.toString(fichiers0));
                String[] fichiers1 = fichiers0[0].split("\\+");
                TreeItem<String> treeItem;
                if (fichiers1.length == 1) {
                    treeItem = new TreeItem<>(fichiers1[0]);
                    root.getChildren().add(treeItem);
                    root = treeItem;
                } else {
                    if (fichiers0.length > 1) {
                        if (fichiers0.length > 2) {
                            treeItem = new TreeItem<>(fichiers1[0]);
                            recupererFichiers(treeItem, fichiers1);
                            root.getChildren().add(treeItem);
                            for (int j = 0; j < fichiers0.length; j+=2) {
                                root = root.getParent();
                                fichiers1 = fichiers0[j].split("\\+");
                                if (!fichiers1[0].equals("")) {
                                    treeItem = new TreeItem<>(fichiers1[0]);
                                    recupererFichiers(treeItem, fichiers1);
                                    root.getChildren().add(treeItem);
                                }else{
                                    treeItem = new TreeItem<>(fichiers1[1]);
                                    root.getChildren().add(treeItem);
                                }
                            }
                        }else{
                            treeItem = new TreeItem<>(fichiers1[0]);
                            recupererFichiers(treeItem, fichiers1);
                            root.getChildren().add(treeItem);
                            String[] fichiers2 = fichiers0[1].split("\\+");
                            for (int j = 1; j < fichiers2.length; j++) {
                                root.getChildren().add(new TreeItem<>(fichiers2[j]));
                            }
                        }
                    }else{
                        treeItem = new TreeItem<>(fichiers1[0]);
                        recupererFichiers(treeItem, fichiers1);
                        root.getChildren().add(treeItem);
                    }
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
        }*/
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
