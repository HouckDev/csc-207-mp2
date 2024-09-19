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
      
      String[] tokens = lineInput.split(" ");
      for (int i = 0; i < tokens.length; i++) {
        BigFraction workingValue = new BigFraction(0);
        if (!validCalculatorToken(tokens[i])) {
          
          if (isNumeric(tokens[i])) {
            workingValue = new BigFraction(tokens[i]);
          } else {
            workingValue = register.get(tokens[i].charAt(0));
          }
          if (i == 0) {
            calculator.clear();
            calculator.add(workingValue);
            continue;
          }
          if (!validCalculatorToken(tokens[i - 1])) {
            calculator.clear();
            calculator.add(workingValue);
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
            calculator.add(workingValue);
            break;
          case "-" :
            calculator.subtract(workingValue);
            break;
          case "*" :
            calculator.multiply(workingValue);
            break;
          case "/" :
            calculator.divide(workingValue);
            break;
          case "STORE" :
            register.store(tokens[i + 1].charAt(0), calculator.get());;
            break;
        }
      }
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
    try {  
      Double.parseDouble(str);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }
} // InteractiveCalculator
