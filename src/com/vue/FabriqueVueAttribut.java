package com.vue;

public class FabriqueVueAttribut implements FabriqueDeVue {
    @Override
    public VueElementClasse creerVueElement() {
        return new VueElementClasse();
    }
}
