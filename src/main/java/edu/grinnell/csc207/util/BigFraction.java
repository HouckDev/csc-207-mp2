package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BigFraction {
  BigInteger numerator = BigInteger.valueOf(1);
  BigInteger denominator = BigInteger.valueOf(1);

  // Creates a fraction
  public BigFraction(BigInteger n,BigInteger d) {
    this.numerator = n;
    this.denominator = d;
  }
  
  // Creates a whole number
  public BigFraction(BigInteger n) {
    this.numerator = n;
    this.denominator = BigInteger.valueOf(1);
  }
  
  /**
   * Get the denominator of this fraction.
   *
   * @return the denominator
   */
  public BigInteger getDenominator() {
    return this.denominator;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   *
   * @return the numerator
   */
  public BigInteger getNumerator() {
    return this.numerator;
  } // numerator()

  /**
   * Add another faction to this fraction.
   *
   * @param addend
   *   The fraction to add.
   *
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denominator.multiply(addend.denominator);
    // The numerator is more complicated
    resultNumerator =
      (this.numerator.multiply(addend.denominator)).add(addend.numerator.multiply(this.denominator));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // add(BigFraction)

  /**
   * Subtract another fraction from this fraction.
   *
   * @param addend
   *   The fraction to subtract.
   *
   * @return the result of the subtraction.
   */
  public BigFraction subtract(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
  
    resultDenominator = this.denominator.multiply(addend.denominator);
    resultNumerator =
      (this.numerator.multiply(addend.denominator)).subtract(addend.numerator.multiply(this.denominator));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // subtract(BigFraction)

  /**
   * Multiply with another fraction.
   *
   * @param addend
   *   The fraction to multiply.
   *
   * @return the result of the multiplication.
   */
  public BigFraction multiply(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultDenominator = this.denominator.multiply(addend.denominator);
    resultNumerator = this.numerator.multiply(addend.numerator);
    
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // multiply(BigFraction)

  /**
   * Divide with another fraction.
   *
   * @param addend
   *   The fraction to divide with.
   *
   * @return the result of the division.
   */
  public BigFraction divide(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

     resultDenominator = this.denominator.multiply(addend.numerator);
    resultNumerator = this.numerator.multiply(addend.denominator);
    
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // divide(BigFraction)

  public String toString() {
    // Special case: It's zero
    if (this.numerator.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.numerator + "/" + this.denominator;
  }
}
