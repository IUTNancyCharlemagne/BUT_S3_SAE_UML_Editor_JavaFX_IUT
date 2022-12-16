package Vue;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class VueElementClasse extends VBox implements ElementDeVue {

    private Text nameText;
    private Rectangle accessibilityRect;

    private Text[] parametersText;
    private Text typeText;
    public VueElementClasse() {
        super();
    }

    public void setName(String name) {
        this.nameText.setText(name);
        this.getChildren().add(nameText);
    }

    public void setParameters(String[] parameters) {
        this.parametersText = new Text[parameters.length];
        int i = 0;
        for (String parameter : parameters) {
            this.parametersText[i] = new Text(parameter);
            this.getChildren().add(this.parametersText[i]);
            i++;
        }
    }

    public void setType(String type) {
        this.typeText = new Text(type);
        this.getChildren().add(typeText);
    }

    public void setAccessibility(String accessibility) {
        this.accessibilityRect = new Rectangle(10,10);
        switch (accessibility) {
            case "public" -> this.accessibilityRect.setFill(Color.GREEN);
            case "private" -> this.accessibilityRect.setFill(Color.RED);
            case "protected" -> this.accessibilityRect.setFill(Color.YELLOW);
        }
        this.getChildren().add(accessibilityRect);
    }
}
