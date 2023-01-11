package com.vue;

/**
 *
 */
public class FabriqueVueAttribut implements FabriqueDeVue {
    /**
     * Methode creerVueElement qui retourne une nouvelle vue d'attributs
     * @return
     */
    @Override
    public VueElementClasse creerVueElement() {
        return new VueElementClasse();
    }
}
