//Дано значение температуры T в градусах Цельсия. 
//Определить значение этой же температуры в градусах Фаренгейта. 
//Температура по Цельсию TC и температура по Фаренгейту TF 
//связаны следующим соотношением: TC = (TF – 32)·5/9.
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
public class TemperatureConverterTest {

    private final double cels; //поле температуры в С
    private final double expectedFahr; //поле ожидаемой температуры в F 

   //конструктор, пр значения температуры для текущего теста
    public TemperatureConverterTest(double cels, double expectedFahr) {
        this.cels = cels;
        this.expectedFahr = expectedFahr;
    }
        // парабетры для теста
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 32}, //значение и ожид результат
                {100, 212},
                {-40, -40},
                {37, 98.6},
                {-273.15, -459.67},
                {5,41}
                
        });
    }

//преобразования температуры
    @Test
    public void testConversion() {
        assertEquals(expectedFahr, TemperatureConverter.celsToFahr(cels), 0.01); //погрешность запятых при сравн
    }
}
//// Метод assertEquals сравнивает ожидаемое значение (expectedFahr) с фактическим результатом,