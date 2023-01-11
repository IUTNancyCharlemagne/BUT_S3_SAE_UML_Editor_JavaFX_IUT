package com.vue;

/**
 *
 */
public class FabriqueVueHeritage implements FabriqueDeVue {
    /**
     * * Methode creerVueElement qui retourne une nouvelle vue d'heritage
     * @return
     */
    @Override
    public VueHeritage creerVueElement() {
        return new VueHeritage();
    }
}
