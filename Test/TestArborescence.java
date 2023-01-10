import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;

public class TestArborescence {
    public static void main(String[] args) {
        FileDirectory root = new FileDirectory("","./src/com/");
        System.out.println(root.arborescence());
    }
}
