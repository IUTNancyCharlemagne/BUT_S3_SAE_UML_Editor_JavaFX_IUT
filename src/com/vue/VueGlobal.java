package com.vue;

import com.modele.Modele;
import javafx.scene.layout.BorderPane;

/**
 *
 */
public class VueGlobal extends BorderPane {
    /**
     * Attributs privés
     */
    private VueMenu vueMenu;
    private VueDiagramme vueDiagramme;
    private Modele modele;

    /**
     * Constructeur de VueGlobale qui prend en paramètre l'attribut modele
     * @param modele
     */
    public VueGlobal(Modele modele) {
        this.modele = modele;
        initBorderPane();
    }

    /**
     * Methode initBorderPane
     */
    public void initBorderPane() {
        vueMenu = new VueMenu(modele, this);
        vueDiagramme = new VueDiagramme();
        modele.enregistrerObservateur(vueDiagramme);
        modele.enregistrerObservateur(vueMenu);
        vueMenu.actualiser(modele);
        vueDiagramme.actualiser(modele);
        VueArborescence vueSelectionRepertoire = new VueArborescence();
        modele.enregistrerObservateur(vueSelectionRepertoire);
        this.setLeft(vueSelectionRepertoire);
        this.setTop(vueMenu);
        this.setCenter(vueDiagramme);
    }

    /**
     * Methode getVueFabriqueClasse qui retourne l'attribut getVueFabriqueClasses de vueDiagramme
     * @return
     */
    public VueFabriqueClasses getVueFabriqueClasse()
    {
        return this.vueDiagramme.getVueFabriqueClasses();
    }
}
