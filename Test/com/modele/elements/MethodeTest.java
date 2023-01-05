package com.modele.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodeTest
{
    Methode m;
    List<Attribut> params;

    @BeforeEach
    void setUp()
    {
        Attribut param1 = new Attribut("att", "String", null);
        params = new ArrayList<>();
        params.add(param1);
        m = new Methode("test", "int", "public", params);
    }

    @Test
    public void test_constructeur_ok()
    {
        //Test
        assertEquals(m.getNom(), "test", "doit etre nomme test");
        assertEquals(m.getType(), "int", "doit etre du meme type");
        assertEquals(m.getVisibilite(), "public", "doit etre de meme visibilite");
        assertEquals(m.getParametres(), params, "doit avoir les memes parametres");
    }

    @Test
    void test_modifier()
    {

    }
}