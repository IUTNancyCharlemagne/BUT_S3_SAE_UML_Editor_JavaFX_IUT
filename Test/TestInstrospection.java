import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("","./src/test","./src/test");
        System.out.println(root.list());
    }
}

