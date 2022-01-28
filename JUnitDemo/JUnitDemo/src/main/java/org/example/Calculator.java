package org.example;

public class Calculator {

    CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int perform(int i, int j) { //2 3 -> 5
        return calculatorService.add(i,j)*i;
//        return (i+j)*i;
    }
}
