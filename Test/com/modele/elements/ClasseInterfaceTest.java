package com.modele.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasseInterfaceTest {

    ClasseInterface classe;

    @BeforeEach
    public void setUp ()
    {
        classe = new ClasseInterface("Test");
    }

    @Test
    public void test00_constructeur_ok()
    {
        //Methode
        ClasseInterface c = new ClasseInterface("TestClasse");

        //Test
        assertEquals("TestClasse", c.getNom(), "le nom doit etre identique");
    }

    @Test
    public void test01_ajouterAttribut_Unique() {
        String attribut = "public int a";
        classe.ajouterAttribut(attribut);
        assertEquals(classe.getAttributs().get(0).getNom(), "a");
        assertEquals(classe.getAttributs().get(0).getType(), "int");
        assertEquals(classe.getAttributs().get(0).getVisibilite(), "public");
    }

    @Test
    public void test02_ajouterAttribut_Multiple() {
        String attribut = "public int a";
        String attribut2 = "private String b";
        String attribut3 = "protected float c";
        classe.ajouterAttribut(attribut);
        classe.ajouterAttribut(attribut2);
        classe.ajouterAttribut(attribut3);
        assertEquals(classe.getAttributs().get(0).getNom(), "a");
        assertEquals(classe.getAttributs().get(0).getType(), "int");
        assertEquals(classe.getAttributs().get(0).getVisibilite(), "public");
        assertEquals(classe.getAttributs().get(1).getNom(), "b");
        assertEquals(classe.getAttributs().get(1).getType(), "String");
        assertEquals(classe.getAttributs().get(1).getVisibilite(), "private");
        assertEquals(classe.getAttributs().get(2).getNom(), "c");
        assertEquals(classe.getAttributs().get(2).getType(), "float");
        assertEquals(classe.getAttributs().get(2).getVisibilite(), "protected");
    }

    @Test
    public void test03_ajouterAttribut_AccessibiliteParDefaut() {
        String attribut = " int a";
        classe.ajouterAttribut(attribut);
        assertEquals(classe.getAttributs().get(0).getNom(), "a");
        assertEquals(classe.getAttributs().get(0).getType(), "int");
        assertEquals(classe.getAttributs().get(0).getVisibilite(), "public");
    }

    @Test
    public void test04_ajouterMethode_Unique() {
        String methode = "public void a()";
        classe.ajouterMethode(methode);
        assertEquals(classe.getMethodes().get(0).getNom(), "a");
        assertEquals(classe.getMethodes().get(0).getVisibilite(), "public");
        assertEquals(classe.getMethodes().get(0).getType(), "void");
    }

    @Test
    public void test05_ajouterMethode_Multiple() {
        String methode = "public void a()";
        String methode2 = "private String b()";
        String methode3 = "protected float c()";
        classe.ajouterMethode(methode);
        classe.ajouterMethode(methode2);
        classe.ajouterMethode(methode3);
        assertEquals(classe.getMethodes().get(0).getNom(), "a");
        assertEquals(classe.getMethodes().get(0).getVisibilite(), "public");
        assertEquals(classe.getMethodes().get(0).getType(), "void");
        assertEquals(classe.getMethodes().get(1).getNom(), "b");
        assertEquals(classe.getMethodes().get(1).getVisibilite(), "private");
        assertEquals(classe.getMethodes().get(1).getType(), "String");
        assertEquals(classe.getMethodes().get(2).getNom(), "c");
        assertEquals(classe.getMethodes().get(2).getVisibilite(), "protected");
        assertEquals(classe.getMethodes().get(2).getType(), "float");
    }

    @Test
    public void test06_ajouterMethode_AvecParametre() {
        String methode = "public void a(int)";
        classe.ajouterMethode(methode);
        assertEquals(classe.getMethodes().get(0).getNom(), "a");
        assertEquals(classe.getMethodes().get(0).getVisibilite(), "public");
        assertEquals(classe.getMethodes().get(0).getType(), "void");
        assertEquals(classe.getMethodes().get(0).getParametres().get(0).getType(), "int");
    }

    @Test
    void ajouterAssociation() {
    }

    @Test
    void ajouterImplementation() {
    }

    @Test
    void ajouterHeritage() {
    }

    @Test
    void modifierAttribut() {
    }

    @Test
    void modifierMethode() {
    }

    @Test
    void modifierHeritage() {
    }

    @Test
    void modifierAssociation() {
    }

    @Test
    void test_modifier() {
        //Methode
        classe.modifier("Teso", "interface");

        //Test
        assertEquals("Teso", classe.getNom(), "le nom doit etre modifie");
        assertEquals("interface", classe.getType(),"le type doit etre modifie");
    }
}
