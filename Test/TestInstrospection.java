import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;

/**
 *
 */
public class TestInstrospection {
    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("","./src/test");
        System.out.println(root.list());
    }
}

