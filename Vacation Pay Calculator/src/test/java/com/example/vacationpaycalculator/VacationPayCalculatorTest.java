package com.example.vacationpaycalculator;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationPayCalculatorTest {


    @Test
    public void testVacationWithoutHolidays() {
        double avgSalary = 3000.0;
        LocalDate startVacationDate = LocalDate.parse("2024-06-01");
        LocalDate endVacationDate = LocalDate.parse("2024-06-10");

        double expectedPay = 10 * (avgSalary / 29.7); // No holidays in this period
        double actualPay = Calculator.calculateVacationPay(avgSalary, startVacationDate, endVacationDate);

        assertEquals(expectedPay, actualPay, 0.01);
    }

    @Test
    public void testVacationWithHolidays() {
        double avgSalary = 3000.0;
        LocalDate startVacationDate = LocalDate.parse("2024-11-01") ;
        LocalDate endVacationDate = LocalDate.parse("2024-11-04") ;  // November 4 holiday


        double expectedPay = 3 * (avgSalary / 29.7); // 4 days 1 holiday
        double actualPay = Calculator.calculateVacationPay(avgSalary, startVacationDate, endVacationDate);

        assertEquals(expectedPay, actualPay, 0.01);
    }

    @Test
    public void testStartAndEndOnSameDay() {
        double avgSalary = 3000.0;
        LocalDate startVacationDate = LocalDate.parse("2024-07-01") ;
        LocalDate endVacationDate = LocalDate.parse("2024-07-01");

        double expectedPay = 1 * (avgSalary / 29.7); // 1 day of vacation
        double actualPay = Calculator.calculateVacationPay(avgSalary, startVacationDate, endVacationDate);

        assertEquals(expectedPay, actualPay, 0.01);
    }

    @Test
    public void testVacationWithOnlyHolidays() {
        double avgSalary = 3000.0;
        LocalDate startVacationDate = LocalDate.parse("2024-11-04");
        LocalDate endVacationDate = LocalDate.parse("2024-11-04");
        // 4 ноября нерабочий праздничный день
        double expectedPay = 0.0;
        double actualPay = Calculator.calculateVacationPay(avgSalary, startVacationDate, endVacationDate);

        assertEquals(expectedPay, actualPay, 0.01);
    }

    @Test
    public void testCalculateVacationPayAcrossYearBoundary() {

        double avgSalary = 1000.0;
        LocalDate startVacationDate = LocalDate.parse("2024-12-31") ;
        LocalDate endVacationDate = LocalDate.parse("2025-01-01");
        // 1 нерабочий день - 1 января


        double result = Calculator.calculateVacationPay(avgSalary, startVacationDate, endVacationDate);


        double expectedVacationPay = 1 * (avgSalary / 29.7);


        assertEquals(expectedVacationPay, result, 0.01, "Vacation pay calculation is incorrect");
    }
}
