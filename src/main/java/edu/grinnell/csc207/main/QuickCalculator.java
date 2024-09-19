package edu.grinnell.csc207.main;

import java.util.Scanner;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;

public class QuickCalculator {
  public static void main(String args[]) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    for (String line : args) {
      //have the calculator parse the line
      calculator.parseCalculation(line,register);

      // print the input and output
      System.out.println("> " + line);
      System.out.println(calculator.get());
    } // for args
  } // main
}
