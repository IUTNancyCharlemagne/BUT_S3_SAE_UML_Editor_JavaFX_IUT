package com.vue;

import com.modele.Sujet;

public interface Observateur {
    void actualiser(Sujet sujet);
}
