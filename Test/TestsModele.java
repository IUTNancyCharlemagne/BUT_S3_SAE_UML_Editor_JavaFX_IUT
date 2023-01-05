import com.modele.Modele;

public class TestsModele {
    public static void main(String[] args){
        Modele modele = new Modele();
        modele.ouvrirDossier("./src/com/modele/composite");
        modele.lireDossier();
    }


}
