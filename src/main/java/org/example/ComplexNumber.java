package org.example;

public class ComplexNumber {
    private int realPart, imaginaryPart;

    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(2, 3);
        ComplexNumber number2 = new ComplexNumber(1, -4);
        System.out.println(number1.multiply(number2));
    }

    public ComplexNumber() {
    }

    public ComplexNumber(int realPart, int imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber(int realPart) {
        this.realPart = realPart;
    }

    public ComplexNumber add(ComplexNumber complexNumber){
        return new ComplexNumber(realPart + complexNumber.realPart, imaginaryPart + complexNumber.imaginaryPart);
    }
    public ComplexNumber subtract(ComplexNumber complexNumber){
        return new ComplexNumber(realPart - complexNumber.realPart, imaginaryPart - complexNumber.imaginaryPart);
    }
    public ComplexNumber multiply(ComplexNumber complexNumber){
        return new ComplexNumber(realPart * complexNumber.realPart - imaginaryPart * complexNumber.imaginaryPart,
                realPart * complexNumber.imaginaryPart + imaginaryPart * complexNumber.realPart);
    }

    @Override
    public String toString() {
        return "{" + realPart + ", " + imaginaryPart +
                '}';
    }
}
