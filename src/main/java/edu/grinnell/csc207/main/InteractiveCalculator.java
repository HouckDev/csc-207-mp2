package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
/**
 * An interactive calculator that allows for terminal line interaction.
 */
public class InteractiveCalculator {
  /**
   * Main method.
   * @param args
   */
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    // Creates a PrintWriter
    PrintWriter output = new PrintWriter(System.out, true);
    while (true) {
      output.println("Enter mathmetical operation or type 'Exit' to stop program");
      output.println("Seperate functions and parameters by spaces");
      String lineInput = inputScanner.nextLine();
      output.println("> " + lineInput);
      if (lineInput.toUpperCase().equals("EXIT")) {
        break;
      } // if

      // have the calculator parse the line
      calculator.parseCalculation(lineInput, register);

      output.println(calculator.get());
    } // while
  } // main
} // InteractiveCalculator
