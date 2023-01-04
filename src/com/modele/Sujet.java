package com.modele;

import com.vue.Observateur;

public interface Sujet
{
    public void enregistrerObservateur(Observateur obs);

    public void supprimerObservateur(Observateur obs);

    public void notifierObservateurs();
}
