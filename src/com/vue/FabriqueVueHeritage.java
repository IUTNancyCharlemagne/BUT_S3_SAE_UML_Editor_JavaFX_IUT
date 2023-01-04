package com.vue;

public class FabriqueVueHeritage implements FabriqueDeVue {
    @Override
    public VueHeritage creerVueElement() {
        return new VueHeritage();
    }
}
