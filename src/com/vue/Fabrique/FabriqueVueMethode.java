package com.vue.Fabrique;

import com.vue.Fabrique.elements.VueElementClasse;

public class FabriqueVueMethode implements FabriqueDeVue {
    @Override
    public VueElementClasse creerVueElement() {
        return new VueElementClasse();
    }
}
