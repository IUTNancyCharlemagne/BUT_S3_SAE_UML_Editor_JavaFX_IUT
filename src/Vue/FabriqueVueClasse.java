package Vue;

public class FabriqueVueClasse implements FabriqueDeVue {

    @Override
    public VueClasse creerVueElement() {
        return new VueClasse();
    }
}
