import java.util.Scanner;

public class JavaQuest3 {
  /**
   * Expected Output of Examples:
   * 
   * Input a month number: 2
   * Input a year: 2016
   * February 2016 has 29 days
   * 
   * Input a month number: 12
   * Input a year: 2014
   * December 2014 has 31 days
   */
  // Program to print the number of days that the month of a year has.

  public static void main(String[] strings) {

    Scanner input = new Scanner(System.in);
    
    int number_Of_DaysInMonth = 0;
    String MonthOfName = "Unknown";

    System.out.print("Input a month number: ");
    int month = input.nextInt();

    System.out.print("Input a year: ");
    int year = input.nextInt();
    input.close();
    
    // Complete the switch statement
    switch (month) {
      case 2:
        MonthOfName = "February";
        // Leap Year -> 29 days in February, otherwise 28.
        // Definition: If a year is divisible by 4 and not divisible by 100, 
        // but include the year divisible by 400.

        // Complete the other months
    }
    System.out.println(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days");

  }
}
