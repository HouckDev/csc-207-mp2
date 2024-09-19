package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;

/**
 * A calculator program that takes command lines as inputs.
 */
public class QuickCalculator {
  /**
   * Main method.
   * @param args
   */
  public static void main(String[] args) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    // Creates a PrintWriter
    PrintWriter output = new PrintWriter(System.out, true);
    for (String line : args) {
      // have the calculator parse the line
      calculator.parseCalculation(line, register);

      // print the input and output
      output.println("> " + line);
      output.println(calculator.get());
    } // for args
  } // main
} // QuickCalculator
