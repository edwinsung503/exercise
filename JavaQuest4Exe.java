public class JavaQuest4Exe {
  public static void main(String[] args) {
    int number = 0;
    int itemcheck = 0;
    boolean hasTenNumber = false;
    for (int i = 0; i < 100; i++) { 
      number = i ;
      if (number % 2 ==0 && number % 3 ==0 && number > 0 ) {
        System.out.println(number);
        itemcheck += 1 ;
        if (itemcheck > 9) {
          break;
        } 
      }
    }
  }
}