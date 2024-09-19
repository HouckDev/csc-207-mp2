package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BigFraction {
  BigInteger numerator = BigInteger.valueOf(1);
  BigInteger denominator = BigInteger.valueOf(1);

  public BigFraction(int n,int d) {
    this.numerator = BigInteger.valueOf(n);
    this.denominator = BigInteger.valueOf(d);
  }
}
