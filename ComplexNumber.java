package numbers;

import calculator.Operand;

import java.util.Objects;

/**
 * Created by melon on 06.12.16.
 */
public class ComplexNumber {
    public ComplexNumber(int real, int imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    private int real;
    private int imagine;

    public int getReal() {
        return real;
    }

    public int getImagine() {
        return imagine;
    }

    public ComplexNumber add(ComplexNumber number) {
        int newReal = getReal() + number.getReal();
        int newImagine = getImagine() + number.getImagine();
        return new ComplexNumber(newReal, newImagine);
    }
    public ComplexNumber sub(ComplexNumber number) {
        int newReal = getReal() - number.getReal();
        int newImagine = getImagine() - number.getImagine();
        return new ComplexNumber(newReal, newImagine);
    }
    public ComplexNumber mul(ComplexNumber number) {
        int newReal = getReal() * number.getReal() - imagine * number.getImagine();
        int newImagine = getReal() * number.getImagine() + getImagine() * number.getReal();
        return new ComplexNumber(newReal, newImagine);
    }

    public ComplexNumber div(ComplexNumber number) {
        int a1 = getReal();
        int b1 = getImagine();
        int a2 = number.getReal();
        int b2 = number.getImagine();
        int den = a2 * a2 + b2 * b2;
        int newReal = (a1 * a2 + b1 * b2) / den;
        int newImagine = (a2 * b1 - a1 * b2) /den;
        return new ComplexNumber(newReal, newImagine);
    }
    public static ComplexNumber parseComplexNumber(String source) {
        return new ComplexNumber(Integer.parseInt(source), 0);
    }
    @Override
    public int hashCode() {
        return getReal() + getImagine();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ComplexNumber))
            return false;
        if (hashCode() != object.hashCode())
            return false;
        if (getImagine() == ((ComplexNumber) object).getImagine() && getReal() == ((ComplexNumber) object).getImagine())
            return true;
        return false;
    }
    @Override
    public String toString() {
        return real + " + " + imagine + "i";
    }
}