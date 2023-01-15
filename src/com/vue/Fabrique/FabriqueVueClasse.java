package com.vue.Fabrique;

import com.vue.Fabrique.elements.VueClasse;

public class FabriqueVueClasse implements FabriqueDeVue {

    @Override
    public VueClasse creerVueElement() {
        return new VueClasse();
    }
}
