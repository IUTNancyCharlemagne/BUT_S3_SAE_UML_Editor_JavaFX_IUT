package com.modele.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
class AttributTest {

    Attribut a;

    /**
     * setUp
     */
    @BeforeEach
    void setUp()
    {
        a = new Attribut("test", "int", "public");
    }

    /**
     * Test du constructeur d'attributs
     */
    @Test
    public void test_constructeur_ok()
    {
        //Test
        assertEquals(a.getNom(), "test", "doit etre nomme test");
        assertEquals(a.getType(), "int", "doit etre du meme type");
        assertEquals(a.getVisibilite(), "public", "doit etre de meme visibilite");
    }

    /**
     * test de modification d'attributs
     */
    @Test
    void test_modifier()
    {
        //Methode
        a.modifier("private", "char", "top");

        //Test
        assertEquals(a.getNom(), "top", "doit etre nomme test");
        assertEquals(a.getType(), "char", "doit etre du meme type");
        assertEquals(a.getVisibilite(), "private", "doit etre de meme visibilite");
    }
}