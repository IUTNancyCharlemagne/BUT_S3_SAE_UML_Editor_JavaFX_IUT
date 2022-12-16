import composite.FileComposite;
import composite.FileDirectory;
import composite.FileFile;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("composite","./Sources/composite");
        System.out.println(root.list());
    }
}

