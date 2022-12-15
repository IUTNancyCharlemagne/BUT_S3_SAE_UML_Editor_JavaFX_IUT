package Vue;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class VueClasse extends Pane implements ElementDeVue{

    private Text titleText;

    private HBox content;
    private ArrayList<VueElementClasse> attributs;
    private ArrayList<VueElementClasse> methodes;
    public VueClasse() {
        super();
        titleText = new Text();
        this.setStyle("-fx-background-color: #ffc75a");
        this.getChildren().add(content);
    }

    public void setTitle(String title) {
        this.titleText.setText(title);
        content.getChildren().add(titleText);
    }

    public void setAttribut(VueElementClasse vueAttribut){
        this.attributs.add(vueAttribut);
        content.getChildren().add(vueAttribut);
    }

    public void setMethode(VueElementClasse vueElementClasse){
        this.methodes.add(vueElementClasse);
        content.getChildren().add(vueElementClasse);
    }
}
