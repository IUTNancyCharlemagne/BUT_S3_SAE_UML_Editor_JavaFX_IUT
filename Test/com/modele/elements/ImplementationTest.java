package com.modele.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class ImplementationTest
{
    Implementation i;
    ClasseInterface depart, destination;

    /**
     * setUp
     */
    @BeforeEach
    void setUp()
    {
        depart = new ClasseInterface("Classe1");
        destination = new ClasseInterface("Classe2");
        i = new Implementation(depart, destination);
    }

    /**
     * Test du constructeur
     */
    @Test
    public void test_constructeur_ok()
    {
        //Test
        assertEquals(i.getInitClasse(), depart, "doit etre la meme classe");
        assertEquals(i.getDestinationClasse(), destination, "doit etre la meme classe");
    }

    /**
     * Test de modification
     */
    @Test
    void test_modifier()
    {
        //init
        ClasseInterface newDepart = new ClasseInterface("Classe3");
        ClasseInterface newDestination = new ClasseInterface("Classe4");

        //Methode
        i.modifier(newDepart, newDestination);

        //Test
        assertEquals(newDepart, i.getInitClasse(), "doit etre la nouvelle classe");
        assertEquals(newDestination, i.getDestinationClasse(), "doit etre la nouvelle classe");
    }
}