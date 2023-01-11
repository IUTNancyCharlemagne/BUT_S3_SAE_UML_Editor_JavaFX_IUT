package com.vue;

/**
 *
 */
public class FabriqueVueClasse implements FabriqueDeVue {

    /**
     * Methode creerVueElement qui retourne une nouvelle vue de classe
     * @return
     */
    @Override
    public VueClasse creerVueElement() {
        return new VueClasse();
    }
}
