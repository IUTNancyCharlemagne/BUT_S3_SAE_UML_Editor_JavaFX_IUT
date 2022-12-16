import java.io.File;

public abstract class FileComposite {

    String path;
    String name;

    public FileComposite (String path, String name) {
        this.path = path;
        this.name = name;
    }
    public abstract String list();

}
