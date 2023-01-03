import composite.FileComposite;
import composite.FileDirectory;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("composite","./src/composite");
        System.out.println(root.list());
    }
}

