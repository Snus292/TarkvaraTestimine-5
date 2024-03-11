/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.math.BigDecimal;
        
public class SalaryCalculator {
    //константы для налогооблагаемого дохода и диапазоном дохода
    private static final double UNTAXED_INCOME_THRESHOLD = 14400.0;
    private static final double MIN_INCOME_RANGE = 14400.0;
    private static final double MAX_INCOME_RANGE = 25200.0;
    private static final double UNTAXED_INCOME_BASE = 7848.0;

    //расчет годовой зп на основе месячной
    public static double AnnualSalary(double monthlySalary) {
        //годовая зп
        double annualSalary = monthlySalary * 12;
        //проверка налогооблагаемого дохода
        if (annualSalary <= UNTAXED_INCOME_THRESHOLD) {
            return annualSalary - UnemployedInsurance(annualSalary) - IncomeTax(annualSalary);
        } else if (annualSalary <= MAX_INCOME_RANGE) {
            //доход,не облагается налогом
            double untaxedIncome = UNTAXED_INCOME_BASE - UNTAXED_INCOME_BASE * ((annualSalary - MIN_INCOME_RANGE) / (MAX_INCOME_RANGE - MIN_INCOME_RANGE));
            return annualSalary - untaxedIncome - UnemployedInsurance(annualSalary) - IncomeTax(annualSalary);
        } else {
            return 0;
        }
    }
    //расчет страх от безработицы
    public static double UnemployedInsurance(double annualSalary) {
        //2% от годовой зп
        return 0.02 * annualSalary;
    }
    //расяет подозодного налога
    public static double IncomeTax(double annualSalary) {
        // Здесь можно добавить логику расчета подоходного налога
        // В данном примере возвращаем 10% от годовой зарплаты
        return 0.1 * annualSalary;
    }
}
