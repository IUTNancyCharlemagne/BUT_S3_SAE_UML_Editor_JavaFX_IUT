import com.model.composite.FileComposite;
import com.model.composite.FileDirectory;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("java/model/composite","./src/composite");
        System.out.println(root.list());
    }
}

