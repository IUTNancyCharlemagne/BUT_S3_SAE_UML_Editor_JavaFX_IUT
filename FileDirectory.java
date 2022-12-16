import java.io.File;

public class FileDirectory extends FileComposite{

    public FileDirectory(String name, String path){
        super(name, path);
    }
    @Override
    public String list() {
        String aff = "-"+this.name;
        File monDossier = new File(this.path);
        File[] fichiers = monDossier.listFiles();
        for (int i = 0; i < fichiers.length; i++){
            File fichier = fichiers[i];
            FileComposite f;
            if (fichiers[i].isDirectory()){
                f = new FileDirectory(fichier.getName(), fichier.getPath());
                aff += "\n| "+f.list();
            }
            else {

                if (fichier.getName().endsWith(".java")) {
                    fichier.getName();
                    f = new FileMyFile(fichier.getName(), fichier.getPath());
                    aff += "\n| " + f.list();
                }
            }
        }
        return aff;
    }
}