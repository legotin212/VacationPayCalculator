package com.example.vacationpaycalculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTestWithTwoArguments {

    @Test
    public void testCalculateVacationPay_ValidInput() {

        double avgSalary = 2970.0;
        int daysOfVacation = 10;
        double expected = daysOfVacation * (avgSalary / 29.7);


        double result = Calculator.calculateVacationPay(avgSalary, daysOfVacation);


        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testCalculateVacationPay_ZeroDaysOfVacation() {

        double avgSalary = 2970.0;
        int daysOfVacation = 0;
        double expected = 0.0;


        double result = Calculator.calculateVacationPay(avgSalary, daysOfVacation);


        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testCalculateVacationPay_LargeAvgSalary() {

        double avgSalary = 100000.0;
        int daysOfVacation = 15;
        double expected = daysOfVacation * (avgSalary / 29.7);


        double result = Calculator.calculateVacationPay(avgSalary, daysOfVacation);


        assertEquals(expected, result, 0.001);
    }

}