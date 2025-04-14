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

@RunWith(Parameterized.class)
public class LionHasManeParameterizedTest {

    @Mock
    Feline feline;

    private Lion lion;

    private final String sex;
    private final boolean expectedHasMane;

    public LionHasManeParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "{index}: Пол = {0}, ожидается грива = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void testDoesHaveManeBySex() {
        assertEquals("Ошибка: для пола " + sex + " ожидалась грива = " + expectedHasMane,expectedHasMane, lion.doesHaveMane());
    }
}