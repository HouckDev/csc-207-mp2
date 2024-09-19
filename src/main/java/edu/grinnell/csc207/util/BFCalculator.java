package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BFCalculator {
  BFRegister register = new BFRegister();
  BigFraction lastComputedValue = new BigFraction(BigInteger.valueOf(0));
  public BigFraction get() {
    return lastComputedValue;
  } // get

  public void add(BigFraction val) {
    lastComputedValue.add(val);
  } // add

  public void subtract(BigFraction val) {
    lastComputedValue.subtract(val);

  } // subtract

  public void multiply(BigFraction val) {
    lastComputedValue.multiply(val);

  } // multiply

  public void divide(BigFraction val) {
    lastComputedValue.divide(val);
     
  } // divide

  public void clear() {
    lastComputedValue = new BigFraction(BigInteger.valueOf(0));
  } // clear
} // BFCalculator
