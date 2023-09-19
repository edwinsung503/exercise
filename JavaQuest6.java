/**
 * Expected output:
 * 1 1 2 3 5 8 13 21 ...
 * 
 */
public class JavaQuest6 {
  public static void main(String[] args) {
    // for loop to print first 15 numbers in Fibonacci Sequence - >  0, 1, 1, 2, 3, 5, 8, 13, 21 ...
    int result = 0;
    int num1 = 0 ;
    int num2 = 1;
    for (int i = 0; i <15; i++) {
      result = num1+num2;//1,
      num1 = num2;//1,
      num2 = result;//0+1, 
      System.out.println(num1);//
      //1st batch
      //result = 0 + 1 = 1
      //num1 = 1 ;
      //num2 = result = 1;
      //2nd batch
      //result = 1 + 1 = 2;
      //num1 = 1 ;
      //num2 = 2;
      //3rd batch
      //result = 1 + 2 = 3
      //num1 = 2;
      //num2 = 3
      //4th batch
      //result = 2 + 3 = 5;
      //num1 = 3 
      //num2 = 5 

    }
  }
}
