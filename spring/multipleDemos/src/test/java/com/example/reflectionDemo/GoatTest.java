package com.example.reflectionDemo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class GoatTest {
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat();
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("com.example.reflectionDemo.Goat", clazz.getName());
        assertEquals("com.example.reflectionDemo.Goat", clazz.getCanonicalName());
    }

    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.example.reflectionDemo.Goat");

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("com.example.reflectionDemo.Goat", clazz.getName());
        assertEquals("com.example.reflectionDemo.Goat", clazz.getCanonicalName());
    }

    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("com.example.reflectionDemo.Goat");
        Class<?> animalClass = Class.forName("com.example.reflectionDemo.Animal");

        int goatMods = goatClass.getModifiers();
        int animalMods = animalClass.getModifiers();

        assertTrue(Modifier.isPublic(goatMods));
        assertTrue(Modifier.isAbstract(animalMods));
        assertTrue(Modifier.isPublic(animalMods));
    }

    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() throws ClassNotFoundException {
        Goat goat = new Goat("goat");
        Class<?> goatClass = goat.getClass();
        Package pkg = goatClass.getPackage();

        assertEquals("com.example.reflectionDemo", pkg.getName());
    }

    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Goat goat = new Goat("goat");
        String str = "any string";

        Class<?> goatClass = goat.getClass();
        Class<?> goatSuperClass = goatClass.getSuperclass();

        assertEquals("Animal", goatSuperClass.getSimpleName());
        assertEquals("Object", str.getClass().getSuperclass().getSimpleName());
    }

    @Test
    public void givenClass_whenGetsImplementedInterfaces_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("com.example.reflectionDemo.Goat");
        Class<?> animalClass = Class.forName("com.example.reflectionDemo.Animal");

        Class<?>[] goatInterfaces = goatClass.getInterfaces();
        Class<?>[] animalInterfaces = animalClass.getInterfaces();

        assertEquals(1, goatInterfaces.length);
        assertEquals(1, animalInterfaces.length);
        assertEquals("Locomotion", goatInterfaces[0].getSimpleName());
        assertEquals("Eating", animalInterfaces[0].getSimpleName());
    }

}