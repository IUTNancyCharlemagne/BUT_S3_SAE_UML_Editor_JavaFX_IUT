package com.vue.Fabrique;

import com.vue.Fabrique.elements.VueHeritage;

public class FabriqueVueHeritage implements FabriqueDeVue {
    @Override
    public VueHeritage creerVueElement() {
        return new VueHeritage();
    }
}
