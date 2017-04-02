/*
 * Samantha McCormick CSC240 Java Programming
 */

/*
 * For this assignment, you will develop an application to calculate the area of a circle or the
 * volume of a sphere based on the user's input for the radius. Circle area = PIr2 Sphere volume =
 * (4/3) PIr3 Accept input for any number of entries (use a loop) for the radius of a circle or
 * sphere. Then calculate the area of that circle and output the result to the screen.
 * 
 */

package assignment1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CircleVolumeCalculator {

  public static void main(String[] args) {
    // Scanner is used in multiple methods, so pass in the input as a param
    Scanner input = new Scanner(System.in);
    String choice = "";
    String repeat = "y";

    introduction();
        
    do {
      System.out.print("Enter C for circle or S for sphere: ");
      choice = input.next();

      getInput(input, choice);

      System.out.print("Do you want to calculate another round object (Y/N)? ");
      repeat = input.next();
      
    } while (repeat.toLowerCase().equals("y"));

    goodbye();

  }
  
  // A method that prompts for and accepts input from the user.
  private static void getInput(Scanner input, String choice) {
    if (!choice.toLowerCase().equals("c") && !choice.toLowerCase().equals("s")) {
      System.out.println("Invalid choice.");
      return;
    }

    System.out.print("Thank you. What is the radius of " + getObject(choice) + " (in inches): ");
    double radius = input.nextDouble();
    
    if (radius == 0) {
      goodbye();
      // end program
      System.exit(0);
    }

    printAnswer(choice, radius);

  }

  // helper method for the object (circle or sphere)
  private static String getObject(String choice) {
    String object = "";

    if (choice.toLowerCase().equals("c")) {
      object = "the circle";
    }

    if (choice.toLowerCase().equals("s")) {
      object = "the sphere";
    }

    return object;
  }
  
  // helper method for the object (circle or sphere)
  private static String getUnit(String choice) {
    String unit = "";

    if (choice.toLowerCase().equals("c")) {
      unit = "area";
    }

    if (choice.toLowerCase().equals("s")) {
      unit = "volume";
    }

    return unit;
  }
  
  
  
  // helper method for the unit (area or volume)

  private static void printAnswer(String choice, double radius) {
    System.out.println("The " + getUnit(choice)  + " of " + getObject(choice) + " with a radius of " + radius
        + " is: " + calculate(choice, radius) + " cubic inches.");
  }
  
  private static BigDecimal calculate(String choice, double radius) {
    double answer = 0;
    
    if (choice.toLowerCase().equals("c")) {
      answer = circleArea(radius);
    }

    if (choice.toLowerCase().equals("s")) {
      answer = sphereArea(radius);
    }
    
    // Round answer to 3 decimals
    BigDecimal roundedAnswer =
        new BigDecimal(answer).setScale(3, RoundingMode.HALF_UP);
    
    return roundedAnswer;
  }

  // A method that thanks and says goodbye to the user just before the program terminates.
  private static void goodbye() {
    System.out.println("Thank you for using the Round Object Calculator.  Goodbye.");
  }

  // A method that calculates the area of the sphere using the input from Step 2.
  private static double circleArea(double radius) {
    // Calculate area PIr^2
    return Math.PI * (radius * radius);
  }

  // A method that calculates the area of the circle using the input from Step 2.
  private static double sphereArea(double radius) {
    // Calculate area 1.333333* PIr^3
    return 1.333333 * Math.PI * (radius * radius * radius);
  }

  // The main method that outputs an introduction to the program.
  private static void introduction() {
    System.out.println("Welcome to the Round Object Calculator.");
    System.out
        .println("This program will calculate the area of a circle or the volume of a sphere.");
    System.out.println("The calculations will be based on the user input radius.");
  }


}
