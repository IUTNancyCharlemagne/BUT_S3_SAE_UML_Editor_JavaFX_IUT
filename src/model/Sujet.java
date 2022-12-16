package model;

import com.Vue.Observateur;

import java.util.List;

public interface Sujet
{
    public void enregistrerObservateur(Observateur obs);

    public void supprimerObservateur(Observateur obs);

    public void notifierObservateurs();
}
