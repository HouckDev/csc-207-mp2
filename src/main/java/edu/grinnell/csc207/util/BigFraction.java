package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Fraction represented by two BigIntegers.
 */
public class BigFraction {
  /**
   * Numerator of the fraction.
   */
  BigInteger num = BigInteger.valueOf(1);
  /**
   * Denomiator of the fraction.
   */
  BigInteger denom = BigInteger.valueOf(1);

  /**
   * Creates a BigFraction from two ints.
   * @param n
   * @param d
   */
  public BigFraction(int n, int d) {
    this.num = BigInteger.valueOf(n);
    this.denom = BigInteger.valueOf(d);
  } // BigFraction(int,int)

  /**
   * Creates a BigFraction from two BigInts.
   * @param n
   * @param d
   */
  public BigFraction(BigInteger n, BigInteger d) {
    this.num = n;
    this.denom = d;
  } // BigFraction(BigInt,BigInt)

  /**
   * Creates a BigFraction from one int (result is a whole number).
   * @param n
   */
  public BigFraction(int n) {
    this.num = BigInteger.valueOf(n);
    this.denom = BigInteger.valueOf(1);
  } // BigFraction(int)

  /**
   * Creates a BigFraction from a string.
   * @param s
   */
  public BigFraction(String s) {
    String[] tokens = s.split("/");

    this.num = BigInteger.valueOf(Integer.valueOf(tokens[0]));
    if (tokens.length >= 2) {
      this.denom = BigInteger.valueOf(Integer.valueOf(tokens[1]));
    } else {
      this.denom = BigInteger.valueOf(1);
    } // if

    // this is scuffed
    BigFraction tempFrac = this.reduce();
    this.num = tempFrac.numerator();
    this.denom = tempFrac.denominator();
  } // BigFraction(String)

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
   *               The fraction to add.
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
    resultnum = (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
  } // add(BigFraction)

  /**
   * Subtract another fraction from this fraction.
   *
   * @param addend
   *               The fraction to subtract.
   *
   * @return the result of the subtraction.
   */
  public BigFraction subtract(BigFraction addend) {
    BigInteger resultnum;
    BigInteger resultdenom;

    resultdenom = this.denom.multiply(addend.denom);
    resultnum = (this.num.multiply(addend.denom)).subtract(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
  } // subtract(BigFraction)

  /**
   * Multiply with another fraction.
   *
   * @param addend
   *               The fraction to multiply.
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
   *               The fraction to divide with.
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

  /**
   * Reduce this fraction.
   *
   * @return the result of the reduction.
   */
  public BigFraction reduce() {

    BigInteger resultnum;
    BigInteger resultdenom;

    resultdenom = this.denom.divide(greatestCommonDivisor(this.numerator(), this.denominator()));
    resultnum = this.num.divide(greatestCommonDivisor(this.numerator(), this.denominator()));

    // Return the computed value
    return new BigFraction(resultnum, resultdenom);
  } // divide(BigFraction)

  /**
   * Creates a BigFraction from a string.
   * @param bigInteger
   * @param bigInteger2
   * @return returns gdc as a BigInteger
   */
  private BigInteger greatestCommonDivisor(BigInteger bigInteger, BigInteger bigInteger2) {
    if (bigInteger2 == BigInteger.valueOf(0)) {
      return bigInteger;
    } // if
    return greatestCommonDivisor(bigInteger2, bigInteger.mod(bigInteger2));
  } // greatestCommonDivisor(BigInt,BigInt)

  /**
   * To make maven happy.
   * @return String
   */
  public String toString() {
    // this is bad since it technically changes the value when we call tostring
    BigFraction reduced = this.reduce();
    // Special case: It's zero
    if (reduced.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    if (reduced.denom.equals(BigInteger.valueOf(1))) {
      return "" + reduced.num;
    } // if it's whole

    // Lump together the string represention of the num,
    // a slash, and the string representation of the denom
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return reduced.num + "/" + reduced.denom;
  } // toString
} // BigFraction
