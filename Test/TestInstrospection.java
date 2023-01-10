import com.modele.composite.FileComposite;
import com.modele.composite.FileDirectory;

public class TestInstrospection {
    public static void main(String[] args) {
        FileComposite root = new FileDirectory("","C:\\Users\\kuene\\Desktop\\Cours\\S3_S4\\Qualite_dev_active_record\\sae_301_developpement_applications-grp1_mangin_malavasi_kuenemann_collin\\src");
        System.out.println(root.list());
    }
}

