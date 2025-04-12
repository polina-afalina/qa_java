package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    // вызываем конструктор feline перед каждым тестом
    @Before
    public void setUp() {
        feline = new Feline();
    }

    // проверяем, что объект feline создан
    @Test
    public void testConstructorInitializesCorrectly() {
        assertNotNull(feline);
    }

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testGetKittensWithoutParams() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
}