package com.example.vacationpaycalculator.controller;

import com.example.vacationpaycalculator.Calculator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Validated
public class CalculatorController {
    @GetMapping("/calculate")
    Double calculate (

                     @RequestParam @Valid @Min(1) double avgSalary,
                     @RequestParam @Valid @Min(value = 1)  int daysOfVacation,

                     @RequestParam(required = false)
                     @Valid
                     @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
                     String startVacationDate,


                     @RequestParam(required = false)
                     @Valid
                     @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
                     String endVacationDate
    ){

        if(startVacationDate==null) {return Calculator.calculateVacationPay(avgSalary,daysOfVacation);}

        LocalDate startDate = LocalDate.parse(startVacationDate);
        LocalDate endDate = LocalDate.parse(endVacationDate);

        if(startDate.isAfter(endDate)){throw new IllegalArgumentException("Wrong Dates of vacation");
        }

        return Calculator.calculateVacationPay(avgSalary, startDate, endDate);

    }
}
