package com.example.effectivejava.chapter02.item17;

import java.math.BigDecimal;
import java.util.Objects;

public class Complex {
      private final double re;
      private final double im;

      public static final Complex ZERO = new Complex(0, 0);
      public static final Complex IBE = new Complex(1, 0);
      public static final Complex I = new Complex(0, 1);

      public Complex(double re, double im) {
        this.re = re;
        this.im = im;
      }

      public double realPart() {
        return re;
      }

      public double imaginaryPart() {
        return im;
      }

      public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
      }

      public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
      }

      public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, im * c.im + im * c.re);
      }

      public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
      }

      @Override
      public int hashCode() {
        return Objects.hash(re, im);
      }

      @Override
      public String toString() {
        return "Complex{" + "re=" + re + ", im=" + im + '}';
      }

      public static void main(String args[]) {
        System.out.println("=======================");
        System.out.println(Complex.ZERO);
        System.out.println("=======================");
        BigDecimal bigDecimal = new BigDecimal("300000");
        bigDecimal.add(BigDecimal.valueOf(30000));
        System.out.println(bigDecimal);



      }
}


