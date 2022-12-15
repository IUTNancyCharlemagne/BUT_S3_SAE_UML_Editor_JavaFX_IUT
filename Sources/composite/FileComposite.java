package composite;

public abstract class FileComposite{

    // Attributs
    protected String name, path;

    // Constructeur
    public FileComposite(String name, String path){
        this.name = name;
        this.path = path;
    }

    // Méthodes
    public abstract String list();

}