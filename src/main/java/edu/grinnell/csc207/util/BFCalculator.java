package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BFCalculator {
  BigFraction lastComputedValue = new BigFraction(0);
  public BigFraction get() {
    return lastComputedValue;
  } // get

  public void add(BigFraction val) {
    lastComputedValue = lastComputedValue.add(val);
    lastComputedValue = lastComputedValue.reduce();
  } // add

  public void subtract(BigFraction val) {
    lastComputedValue = lastComputedValue.subtract(val);
    lastComputedValue = lastComputedValue.reduce();
  } // subtract

  public void multiply(BigFraction val) {
    lastComputedValue = lastComputedValue.multiply(val);
    lastComputedValue = lastComputedValue.reduce();

  } // multiply

  public void divide(BigFraction val) {
    lastComputedValue = lastComputedValue.divide(val);
    lastComputedValue = lastComputedValue.reduce();
     
  } // divide

  public void clear() {
    lastComputedValue = new BigFraction(0);
  } // clear
} // BFCalculator
