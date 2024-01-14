/*Question : Given an integer n,
 add a dollar sign ("$") and a comma (",") as the thousands separator and return it in string format. */
/*Constraints:

0 <= n <= 231 - 1 */
public class JavaQuest29 {
  public static void main(String[] args) {
    System.out.println(separator(85));// $85
    System.out.println(separator(0));// $0
    System.out.println(separator(1000));// 1,000
    System.out.println(separator(123987405));// $123,987,405
    System.out.println(separator(1000000));// 1,000,000

  }

  public static String separator(int n) {
    // code here
    StringBuilder sb = new StringBuilder();
    String str = Integer.toString(n);
    int count = 0 ;
    if (n == 0){
        return "$"+str;
    }
    while (n >=1){
        n = n / 10;
        sb.append(str.substring(str.length()-1));
        str = str.substring(0,str.length()-1);
        count ++;
        if (count % 3 == 0 && str.length() >0) {
            sb.append(",");
        }
    }
    sb.append("$").reverse();
    return sb.toString();

  }

}
