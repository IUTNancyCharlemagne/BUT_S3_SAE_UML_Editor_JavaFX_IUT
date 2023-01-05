package com.modele.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssociationTest {

    Association a;
    ClasseInterface depart, destination;

    @BeforeEach
    void setUp()
    {
        depart = new ClasseInterface("Classe1");
        destination = new ClasseInterface("Classe2");
        a = new Association(depart, destination, "test", "public");
    }

    @Test
    public void test_constructeur_ok()
    {
        //Test
        assertEquals(a.getInitClasse(), depart, "doit etre la meme classe");
        assertEquals(a.getDestination(), destination, "doit etre la meme classe");
        assertEquals(a.getNom(), "test", "doit etre nomme test");
        assertEquals(a.getVisibilite(), "public", "doit etre de meme visibilite");
    }

    @Test
    void modifier() {
    }
}