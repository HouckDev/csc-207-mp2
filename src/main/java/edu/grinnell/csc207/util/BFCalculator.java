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

  public void parseCalculation(String lineInput, BFRegisterSet register) {
    String[] tokens = lineInput.split(" ");
    for (int i = 0; i < tokens.length; i++) {
      BigFraction workingValue = new BigFraction(0);
      if (!validthisToken(tokens[i])) {
        
        if (isNumeric(tokens[i])) {
          workingValue = new BigFraction(tokens[i]);
        } else {
          workingValue = register.get(tokens[i].charAt(0));
        }
        if (i == 0) {
          this.clear();
          this.add(workingValue);
          continue;
        }
        if (!validthisToken(tokens[i - 1])) {
          this.clear();
          this.add(workingValue);
          continue;
        }
        continue;
      }

      if (isNumeric(tokens[i + 1])) {
        workingValue = new BigFraction(tokens[i + 1]);
      } else {
        workingValue = register.get(tokens[i + 1].charAt(0));
      }
      switch (tokens[i]) {
        case "+" :
          this.add(workingValue);
          break;
        case "-" :
          this.subtract(workingValue);
          break;
        case "*" :
          this.multiply(workingValue);
          break;
        case "/" :
          this.divide(workingValue);
          break;
        case "STORE" :
          register.store(tokens[i + 1].charAt(0), this.get());;
          break;
      }
    }
  }

  public static boolean validthisToken(String token) {
    String[] tokenCommands = {"+","-","/","*","STORE"};
    for (String commandToken : tokenCommands) {
      if (commandToken.equals(token)) { return true;}
    }
    return false;
  } // validthisToken(String)

  public static boolean isNumeric(String str) { 
    for (int i = 0; i < str.length(); i++){
      char c = str.charAt(i);        
      
      if (Character.isDigit(c) || c == '/') {
      } else {
        return false;
      }
    }
    return true;
  } // isNumeric(String)
} // BFthis
