package com.vue;

import com.model.Sujet;

public interface Observateur {
    void actualiser(Sujet sujet);
}
