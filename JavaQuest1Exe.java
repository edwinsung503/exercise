public class JavaQuest1Exe {
  public static void main(String[]args) {
    System.out.println("I am going to add two numbers together:");//I am going to add two numbers together:

    int first = 31;
    int second = 42;

    System.out.println("The first one: "+first);//31
    System.out.println("The second one: "+second);//42

    int sum = 0;
    sum = first+second;
    System.out.println("The sum is "+sum);//73

    int subtract = 0 ;
    subtract = second - first ;
    System.out.println("The subtraction reuslt is "+subtract);//11

    byte b1 = 60;
    byte b2 = 70;
    sum = 0;
    sum = b1+b2;
    System.out.println("The another sum result is "+sum);//130

    boolean varB = false;
    boolean varC = true;
    System.out.println("The variable varB is "+varB);
    System.out.println("The variable varC is "+varC);

    float fnumber = -130.2f;
    double dnumber = -20.5d;
    System.out.println("The variable fnumber is "+fnumber);
    System.out.println("The variable dnumber is "+dnumber);

    // Find reminder. Declare variable a & reminder
    int a = 7;
    int b = 6 ;
    int reminder = a - b ;
    System.out.println("The variable reminder is "+reminder);

    // declare a variable x and assign value to it.
    int e = 7;
    int o = 8;
    int y = 4;
    int x = 2;

    int result = e - o * x / y;
    System.out.println("The result is " + result);//3
  }
}
