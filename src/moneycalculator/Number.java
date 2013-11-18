package moneycalculator;

public class Number {

    private double numerator;
    private double denominator;

    public Number(int number) {
        numerator = number;
        denominator = 1;
        while (number % 1 != 0) {
            numerator *= 10;
            denominator *= 10;
        }
        //falta llamar al metodo de reducir
    }

    public Number(double number) {
        numerator = number;
        denominator = 1;
        while (number % 1 != 0) {
            numerator *= 10;
            denominator *= 10;
        }
        //falta llamar al metodo de reducir
    }

    public Number(long number) {
        numerator = number;
        denominator = 1;
        while (number % 1 != 0) {
            numerator *= 10;
            denominator *= 10;
        }
        //falta llamar al metodo de reducir
    }

    public Number(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Number add(Number a, Number b) {
        return new Number(a.numerator + b.numerator, a.denominator + b.denominator);
    }

    public Number substract(Number a, Number b) {
        //return new Number (a.numerator-b.numerator, a.denominator - b.denominator);
    }

    public Number divide(Number a, Number b) {
        //return new Number (a.numerator/b.numerator, a.denominator / b.denominator);
    }

    public Number multiplicate(Number a, Number b) {
        return new Number(a.numerator * b.numerator, a.denominator * b.denominator);
    }

    private Number reduce(Number number) {
    }
}
