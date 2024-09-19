package edu.grinnell.csc207.main;

import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

public class InteractiveCalculator {
  public static void main(String args[]) {
    Scanner inputScanner = new Scanner(System.in); 
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    while (true) {
      System.out.println("Enter mathmetical operation or type 'Exit' to stop program");
      System.out.println("Seperate functions and parameters by spaces");
      String lineInput = inputScanner.nextLine();
      System.out.println("> " + lineInput);
      if (lineInput.toUpperCase().equals("EXIT")) {break;}
      
      //have the calculator parse the line
      calculator.parseCalculation(lineInput,register);

      System.out.println(calculator.get());
    } // while
  } // main

  public static boolean validCalculatorToken(String token) {
    String[] tokenCommands = {"+","-","/","*","STORE"};
    for (String commandToken : tokenCommands) {
      if (commandToken.equals(token)) { return true;}
    }
    return false;
  }
  public static boolean isNumeric(String str) { 
    for (int i = 0; i < str.length(); i++){
      char c = str.charAt(i);        
      
      if (Character.isDigit(c) || c == '/') {
      } else {
        return false;
      }
    }
    return true;
  }
} // InteractiveCalculator
