import composite.FileComposite;
import composite.FileFile;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileFile("composite.FileFile","");
        System.out.println(root.list());
    }
}

