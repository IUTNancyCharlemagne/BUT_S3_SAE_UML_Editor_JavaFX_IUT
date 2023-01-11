package com.vue;

/**
 *
 */
public class FabriqueVueMethode implements FabriqueDeVue {
    /**
     * Methode creerVueElement qui retourne une nouvelle vue de methode
     * @return
     */
    @Override
    public VueElementClasse creerVueElement() {
        return new VueElementClasse();
    }
}
