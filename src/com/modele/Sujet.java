package com.modele;

import com.modele.elements.Element;
import com.vue.Observateur;

import java.util.List;

public interface Sujet
{
    public void enregistrerObservateur(Observateur obs);

    public void supprimerObservateur(Observateur obs);

    public void notifierObservateurs();

    List<Element> getElements();
}
