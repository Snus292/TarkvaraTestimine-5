//A*x2 +B*x + C=0,
//где A, B,C -это вводимые пользователем коэффициенты, 
//от которых зависит результат решения этого уравнения. 
//Программа должна использовать для нахождения 
//действительных корней следующие выражения:
//x1 = (-B + √D) / (2*A)
//x2 = (-B - √D) / (2*A)
//D - это дискриминант, вычисляемый по формуле D = B2 - 4*A*C.
//Если дискриминант отрицательный, то 
//действительные корни отсутствуют. 

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
public class QuadraticEquationTest {

    
    //поля корни уравн
    private final double A;
    private final double B;
    private final double C;
    private final double[] expectedRoots;

    //конструктор. связь параметров коллекции с полями класса
    public QuadraticEquationTest(double A, double B, double C, double[] expectedRoots) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.expectedRoots = expectedRoots;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{ //возврат коллекии в виде массиве параметров
            // A , B ,C корни
                {1.0, -3.0, 2.0, new double[]{2.0, 1.0}}, //D +, два корня
                {1.0, 0.0, -1.0, new double[]{1.0, -1.0}}, //D +, два корня
                {1.0, -2.0, 1.0, new double[]{1.0}}, //D=0, один корень
                {2.0, 1.0, 1.0, new double[]{}}, //D -,корней нет
                {0.0, 5.0, 2.0, new double[]{-0.4}} //линейное урав,тк A=0, один корень
        });
    }
    //тест решения уравнений
    @Test
    public void testQuadraticEquation() {
        assertArrayEquals(expectedRoots, QuadraticEquation.solve(A, B, C), 0.01);//погрешность десятых
    }
}