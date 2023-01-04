package com.vue;

public class FabriqueVueClasse implements FabriqueDeVue {

    @Override
    public VueClasse creerVueElement() {
        return new VueClasse();
    }
}
