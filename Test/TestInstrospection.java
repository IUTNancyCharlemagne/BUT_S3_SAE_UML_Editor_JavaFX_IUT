import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("java/model/composite","./src/composite");
        System.out.println(root.list());
    }
}

