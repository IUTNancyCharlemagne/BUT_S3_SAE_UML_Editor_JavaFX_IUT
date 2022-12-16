package com.Vue;

public class FabriqueVueMethode implements FabriqueDeVue {
    @Override
    public VueElementClasse creerVueElement() {
        return new VueElementClasse();
    }
}
