package com.modele.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeritageTest {

    Heritage h;
    ClasseInterface depart, destination;

    @BeforeEach
    void setUp()
    {
        depart = new ClasseInterface("Classe1");
        destination = new ClasseInterface("Classe2");
        h = new Heritage(depart, destination);
    }

    @Test
    public void test_constructeur_ok()
    {
        //Test
        assertEquals(h.getInitClasse(), depart, "doit etre la meme classe");
        assertEquals(h.getDestinationClasse(), destination, "doit etre la meme classe");
    }

    @Test
    void test_modifier()
    {
        //init
        ClasseInterface newDepart = new ClasseInterface("Classe3");
        ClasseInterface newDestination = new ClasseInterface("Classe4");

        //Methode
        h.modifier(newDepart, newDestination);

        //Test
        assertEquals(newDepart, h.getInitClasse(), "doit etre la nouvelle classe");
        assertEquals(newDestination, h.getDestinationClasse(), "doit etre la nouvelle classe");

    }
}