package edu.grinnell.csc207.util;

import java.util.HashMap;

/**
 * A register to hold BigFractions for use in calculations.
 */
public class BFRegisterSet {
  /**
   * The register's hash map for stored fractions.
   */
  HashMap<Character, BigFraction> register = new HashMap<Character, BigFraction>();

  /**
   * Sets value at key.
   * @param key
   * @param val
   */
  public void store(char key, BigFraction val) {
    register.put(key, val);
  } // store

  /**
   * Returns the value at key of the register.
   * @param key
   * @return the value
   */
  public BigFraction get(char key) {
    return register.get(key);

  } // get
} // BFRegister
