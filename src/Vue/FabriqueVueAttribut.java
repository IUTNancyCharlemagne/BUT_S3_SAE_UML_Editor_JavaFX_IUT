package Vue;

public class FabriqueVueAttribut implements FabriqueDeVue {
    @Override
    public VueAttribut creerVueElement() {
        return new VueAttribut();
    }
}
