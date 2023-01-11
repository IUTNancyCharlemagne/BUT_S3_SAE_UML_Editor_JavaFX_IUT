package com.modele;

import com.modele.elements.ClasseInterface;
import com.vue.Observateur;

import java.util.List;

/**
 *
 */
public interface Sujet
{
    /**
     * Methode enregistrerObservateur qui prend en paramètre l'attribut obs
     * @param obs
     */
    public void enregistrerObservateur(Observateur obs);

    /**
     * Methode supprimerObservateur qui prend en paramètre l'attribut obs
     * @param obs
     */
    public void supprimerObservateur(Observateur obs);

    /**
     * Methode notifierObservateurs
     */
    public void notifierObservateurs();

    /**
     *
     * @return
     */
    List<ClasseInterface> getClasses();
}
