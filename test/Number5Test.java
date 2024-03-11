/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Number5Test {

    // параметры для тестирования
    private int inputN;
    private int expectedCount;

    // конструктор, связывающий параметры с полями класса
    public Number5Test(int inputN, int expectedCount) {
        this.inputN = inputN;
        this.expectedCount = expectedCount;
    }

    // параметры для тестирования
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 3},   // N = 20, 3 четных числа
                {30, 5},   // N = 30, 5 четных чисел
                {10, 0},   // N = 10, 0 четных чисел
                {40, 8},   // N = 40, 9 четных чисел
                {25, 4}    // N = 25, 3 четных числа
        });
    }
    // четность числа
    @Test
    public void isEvenTest() {
        int result = Nuber5.DivisionByFour(inputN);
        assertTrue(result % 2 == 0);
        assertEquals(expectedCount, result);
    }

//нечетность числа
    @Test
    public void isNotOddTest() {
        int result = Nuber5.DivisionByFour(inputN);
        assertFalse(result % 2 != 0);
        assertEquals(expectedCount, result);
    }

    // сам тест на ожид результат
    @Test
    public void DivisionByFourTest() {
        assertEquals(expectedCount, Nuber5.DivisionByFour(inputN));
    }
}
