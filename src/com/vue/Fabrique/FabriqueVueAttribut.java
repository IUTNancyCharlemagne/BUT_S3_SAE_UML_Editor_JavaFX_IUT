package com.vue.Fabrique;

import com.vue.Fabrique.elements.VueElementClasse;

public class FabriqueVueAttribut implements FabriqueDeVue {
    @Override
    public VueElementClasse creerVueElement() {
        return new VueElementClasse();
    }
}
