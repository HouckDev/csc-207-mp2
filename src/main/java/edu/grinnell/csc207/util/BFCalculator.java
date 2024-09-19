package edu.grinnell.csc207.util;

/**
 * A digital representation of a calculator.
 */
public class BFCalculator {
  /**
   * The value stored in the calculator.
   */
  BigFraction lastComputedValue = new BigFraction(0);

  /**
   * Gets the value stored in calculator.
   * @return the last value calculated
   */
  public BigFraction get() {
    return lastComputedValue;
  } // get

  /**
   * Adds the calculator.
   * @param val
   */
  public void add(BigFraction val) {
    lastComputedValue = lastComputedValue.add(val);
    lastComputedValue = lastComputedValue.reduce();
  } // add

  /**
   * Subtracts the calculator.
   * @param val
   */
  public void subtract(BigFraction val) {
    lastComputedValue = lastComputedValue.subtract(val);
    lastComputedValue = lastComputedValue.reduce();
  } // subtract

  /**
   * Multiplies the calculator.
   * @param val
   */
  public void multiply(BigFraction val) {
    lastComputedValue = lastComputedValue.multiply(val);
    lastComputedValue = lastComputedValue.reduce();

  } // multiply

  /**
   * Divides the calculator.
   * @param val
   */
  public void divide(BigFraction val) {
    lastComputedValue = lastComputedValue.divide(val);
    lastComputedValue = lastComputedValue.reduce();

  } // divide

  /**
   * clears the last value.
   */
  public void clear() {
    lastComputedValue = new BigFraction(0);
  } // clear

  /**
   * Parses a line into induvidual calculations.
   * @param lineInput
   * @param register
   */
  public void parseCalculation(String lineInput, BFRegisterSet register) {
    String[] tokens = lineInput.split(" ");
    for (int i = 0; i < tokens.length; i++) {
      BigFraction workingValue = new BigFraction(0);
      if (!validCalculatorToken(tokens[i])) {

        if (isNumeric(tokens[i])) {
          workingValue = new BigFraction(tokens[i]);
        } else {
          workingValue = register.get(tokens[i].charAt(0));
        } // if else
        if (i == 0) {
          this.clear();
          this.add(workingValue);
          continue;
        } // if
        if (!validCalculatorToken(tokens[i - 1])) {
          this.clear();
          this.add(workingValue);
          continue;
        } // if
        continue;
      } // if

      if (isNumeric(tokens[i + 1])) {
        workingValue = new BigFraction(tokens[i + 1]);
      } else {
        workingValue = register.get(tokens[i + 1].charAt(0));
      } // if else
      switch (tokens[i]) {
        case "+":
          this.add(workingValue);
          break;
        case "-":
          this.subtract(workingValue);
          break;
        case "*":
          this.multiply(workingValue);
          break;
        case "/":
          this.divide(workingValue);
          break;
        case "STORE":
          register.store(tokens[i + 1].charAt(0), this.get());
          break;
        default :
          break;
      } // switch
    } // for
  } // parseCalculation

  /**
   * Checks if a token is a calculator operation.
   * @param token
   * @return if the token is an operation
   */
  public static boolean validCalculatorToken(String token) {
    String[] tokenCommands = {"+", "-", "/", "*", "STORE"};
    for (String commandToken : tokenCommands) {
      if (commandToken.equals(token)) {
        return true;
      } // if
    } // for
    return false;
  } // validthisToken(String)

  /**
   * Checks if a string is a representation of a number.
   * @param str
   * @return is numeric?
   */
  public static boolean isNumeric(String str) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      if (!(Character.isDigit(c) || c == '/')) {
        return false;
      } // if
    } // for
    return true;
  } // isNumeric(String)
} // BFthis
