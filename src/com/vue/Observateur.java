package com.vue;

import com.modele.Sujet;

/**
 *
 */
public interface Observateur {
    /**
     * Methode actualiser qui prend en paramètre l'attribut sujet
     * @param sujet
     */
    void actualiser(Sujet sujet);
}
