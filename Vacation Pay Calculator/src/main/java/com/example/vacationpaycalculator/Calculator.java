package com.example.vacationpaycalculator;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Calculator {

    private static List<LocalDate> holidays;

    public static List<LocalDate> getHolidays() {
        if (holidays == null) {
            holidays = new LinkedList<>();
            holidays.add(LocalDate.of(2024, 1, 1)); // Новый год
            holidays.add(LocalDate.of(2024, 1, 2)); // Новогодние каникулы
            holidays.add(LocalDate.of(2024, 1, 3));
            holidays.add(LocalDate.of(2024, 1, 4));
            holidays.add(LocalDate.of(2024, 1, 5));
            holidays.add(LocalDate.of(2024, 1, 6));
            holidays.add(LocalDate.of(2024, 1, 7)); // Рождество Христово
            holidays.add(LocalDate.of(2024, 2, 23)); // День защитника Отечества
            holidays.add(LocalDate.of(2024, 3, 8)); // Международный женский день
            holidays.add(LocalDate.of(2024, 5, 1)); // Праздник Весны и Труда
            holidays.add(LocalDate.of(2024, 5, 9)); // День Победы
            holidays.add(LocalDate.of(2024, 6, 12)); // День России
            holidays.add(LocalDate.of(2024, 11, 4)); // День народного единства

            holidays.add(LocalDate.of(2025, 1, 1));  // Новый год
            holidays.add(LocalDate.of(2025, 1, 2));  // Новогодние каникулы
            holidays.add(LocalDate.of(2025, 1, 3));
            holidays.add(LocalDate.of(2025, 1, 4));
            holidays.add(LocalDate.of(2025, 1, 5));
            holidays.add(LocalDate.of(2025, 1, 6));
            holidays.add(LocalDate.of(2025, 1, 7));  // Рождество Христово
            holidays.add(LocalDate.of(2025, 2, 23)); // День защитника Отечества
            holidays.add(LocalDate.of(2025, 3, 8));  // Международный женский день
            holidays.add(LocalDate.of(2025, 5, 1));  // Праздник Весны и Труда
            holidays.add(LocalDate.of(2025, 5, 9));  // День Победы
            holidays.add(LocalDate.of(2025, 6, 12)); // День России
            holidays.add(LocalDate.of(2025, 11, 4)); // День народного единства

        }
        return holidays;
    }
    public static double calculateVacationPay(double avgSalary, int daysOfVacation){
        return daysOfVacation * (avgSalary / 29.7);
    }

    public static double calculateVacationPay(double avgSalary, LocalDate startDate,
                                              LocalDate endDate) {

        long holidayCount = getHolidays().stream()
                .filter(holiday -> !holiday.isBefore(startDate) && !holiday.isAfter(endDate) || holiday.equals(endDate) || holiday.equals(startDate))
                .count();
        int daysOfVacation = (int) ChronoUnit.DAYS.between(startDate, endDate);
        return calculateVacationPay(avgSalary, daysOfVacation -(int)holidayCount + 1);
    }
}
