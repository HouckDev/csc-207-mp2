package edu.grinnell.csc207.util;

import java.util.HashMap;

public class BFRegisterSet {
  HashMap<Character,BigFraction> register = new HashMap<Character,BigFraction>();
 
  /**
   * @param register
   * @param val
   */
  public void store(char key, BigFraction val) {
    register.put(key,val);
  } // store

  /**
   * @param register
   * @return
   */
  public BigFraction get(char key) {
    return register.get(key);

  } // get
} // BFRegister
