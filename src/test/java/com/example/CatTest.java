package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    // мокаем cat
    @Mock
    Feline feline;
    private Cat cat;

    // вызываем конструктор cat перед каждым тестом
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    // проверяем, что объект cat создан
    @Test
    public void testConstructorInitializesCorrectly() {
        assertNotNull("Ошибка: объект класса Cat не создан.",cat);
    }

    @Test
    public void testGetSound() {
        assertEquals("Ошибка: ожидалась строка \"Мяу\".", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        assertEquals("Ошибка: ожидался список [Животные, Птицы, Рыба].",Arrays.asList("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}