package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", feline); // пол можно любой допустимый
    }

    // проверяем, что объект lion создан
    @Test
    public void testConstructorInitializesCorrectly() {
        assertNotNull(lion);
    }

    @Test
    public void testGetKittensReturnsDefaultValue() {
        when(feline.getKittens()).thenReturn(1); // можно мокнуть поведение
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFoodReturnsPredatorFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(feline).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Другое", feline);
    }

    @Test
    public void testInvalidSexThrowsExceptionWithMessage() {
        try {
            new Lion("Другое", feline);
            fail("Ожидалось исключение!");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}