package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BigFraction {
  BigInteger num = BigInteger.valueOf(1);
  BigInteger denom = BigInteger.valueOf(1);

  // Creates a BigFraction from two ints
  public BigFraction(int n, int d) {
    this.num = BigInteger.valueOf(n);
    this.denom = BigInteger.valueOf(d);
  }

  // Creates a BigFraction from two BigInts
  public BigFraction(BigInteger n, BigInteger d) {
    this.num = n;
    this.denom = d;
  }
  
  // Creates a BigFraction from one int (result is a whole number)
  public BigFraction(int n) {
    this.num = BigInteger.valueOf(n);
    this.denom = BigInteger.valueOf(1);
  }
  
  // Creates a BigFraction from a string
  public BigFraction(String s) {
    String[] tokens = s.split("/");

    this.num = BigInteger.valueOf(Integer.valueOf(tokens[0]));
    if (tokens.length >= 2) {
      this.denom = BigInteger.valueOf(Integer.valueOf(tokens[1]));
    } else {
      this.denom = BigInteger.valueOf(1);
    }
  }

  /**
   * Get the denom of this fraction.
   *
   * @return the denom
   */
  public BigInteger denominator() {
    return this.denom;
  } // denom()

  /**
   * Get the num of this fraction.
   *
   * @return the num
   */
  public BigInteger numerator() {
    return this.num;
  } // num()

  /**
   * Add another faction to this fraction.
   *
   * @param addend
   *   The fraction to add.
   *
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultnum;
    BigInteger resultdenom;

    // The denom of the result is the product of this object's
    // denom and addend's denom
    resultdenom = this.denom.multiply(addend.denom);
    // The num is more complicated
    resultnum =
      (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
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
    BigInteger resultnum;
    BigInteger resultdenom;
  
    resultdenom = this.denom.multiply(addend.denom);
    resultnum =
      (this.num.multiply(addend.denom)).subtract(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
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
    BigInteger resultnum;
    BigInteger resultdenom;

    resultdenom = this.denom.multiply(addend.denom);
    resultnum = this.num.multiply(addend.num);
    
    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
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
    BigInteger resultnum;
    BigInteger resultdenom;

     resultdenom = this.denom.multiply(addend.num);
    resultnum = this.num.multiply(addend.denom);
    
    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
  } // divide(BigFraction)

  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the num,
    // a slash, and the string representation of the denom
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  }
}
