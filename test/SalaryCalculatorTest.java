
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SalaryCalculatorTest {
    
//    поля,хранения параметров тестов
    private double monthlySalary;
    private double expectedAnnualSalary;

    // конструктор, связывающий параметры коллекции с полями класса
    public SalaryCalculatorTest(double monthlySalary, double expectedAnnualSalary) {
        this.monthlySalary = monthlySalary;
        this.expectedAnnualSalary = expectedAnnualSalary;
    }

    // возвращает тип Collection и маркирует его аннотацией @Parameter.
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            //параметры
                {1000.0, 10560.0}, //низкий доход
                {2000.0, 20248.0}, //средний доход
                {3000.0, 0.0}, //высокий доход
                {0.0, 0.0}, //нулевой
                
                
        });
    }

    // проверка годовой зарплаты
    @Test
    public void testAnnualSalary() {
        double actualAnnualSalary = SalaryCalculator.AnnualSalary(monthlySalary);
        assertEquals(expectedAnnualSalary, actualAnnualSalary, 0.01);
    }

    // проверка страх по безработице
    @Test 
    public void testUnemployedInsurance() {
        double annualSalary = monthlySalary * 12;
        double expectedInsurance = 0.02 * annualSalary;
        double actualInsurance = SalaryCalculator.UnemployedInsurance(annualSalary);
        assertEquals(expectedInsurance, actualInsurance, 0.01);
    }
// ппроверка налога
    @Test
    public void testIncomeTax() {
        double annualSalary = monthlySalary * 12;
        double expectedTax = 0.1 * annualSalary;
        double actualTax = SalaryCalculator.IncomeTax(annualSalary);
        assertEquals(expectedTax, actualTax, 0.01);
    }
   

    // Новый тест: проверка для месячной зарплаты, равной нулю
    @Test
    public void testZeroMonthlySalary() {
        double actualAnnualSalary = SalaryCalculator.AnnualSalary(0.0);
        assertEquals(0.0, actualAnnualSalary, 0.01);
    }
    
}

