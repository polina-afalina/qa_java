package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionGetKittensParameterizedTest {

    @Mock
    Feline feline;

    private Lion lion;

    private final int inputKittens;
    private final int expectedKittens;

    public LionGetKittensParameterizedTest(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters(name = "{index}: getKittens({0}) => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10}
        });
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(feline.getKittens()).thenReturn(inputKittens);
        lion = new Lion("Самец", feline); // пол можно любой допустимый
    }

    @Test
    public void testGetKittensReturnsCorrectValue() {
        assertEquals(expectedKittens, lion.getKittens());
    }
}