package Vue;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class VueDiagramme extends StackPane implements Observateur {

    private ArrayList<VueClasse> classes;
    public void actualiser(Sujet sujet) {
        this.getChildren().clear();
        ArrayList<Classe> classes = sujet.getClasses();
        for (Classe classe : classes) {
            FabriqueDeVue fabriqueDeVue = new FabriqueVueClasse();
            VueClasse vueElement = (VueClasse) fabriqueDeVue.creerVueElement();
            vueElement.setTitle(classe.getNom());
            for (Attribut attribut : classe.getAttributs()) {
                fabriqueDeVue = new FabriqueVueAttribut();
                VueElementClasse vueAttribut = (VueElementClasse) fabriqueDeVue.creerVueElement();
                vueElement.setAttribut(vueAttribut);
            }
            for (Methode methode : classe.getMethodes()) {
                fabriqueDeVue = new FabriqueVueMethode();
                VueElementClasse vueElementClasse = (VueElementClasse) fabriqueDeVue.creerVueElement();
                vueElement.setMethode(vueElementClasse);
            }
            this.getChildren().add(vueElement);
        }

    }

    public VueDiagramme() {
        super();
        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
