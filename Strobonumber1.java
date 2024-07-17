import java.util.*;
// Using Recursion
class Strobonumber1 {
    // Java program to print all
// Strobogrammatic number of length n
import java.util.*;
 
class GFG {
 
  // definition function
  static ArrayList<String> numdef(int n, int length)
  {
    ArrayList<String> result = new ArrayList<String>();
    if (n == 0)
      return result;
    if (n == 1) {
      result.add("1");
      result.add("0");
      result.add("8");
      return result;
    }
 
    ArrayList<String> middles = numdef(n - 2, length);
 
    for (String middle : middles) {
      if (n != length)
        result.add("0" + middle + "0");
 
      result.add("8" + middle + "8");
      result.add("1" + middle + "1");
      result.add("9" + middle + "6");
      result.add("6" + middle + "9");
    }
    return result;
  }
 
  // strobogrammatic function
  static ArrayList<String> strobogrammatic_num(int n)
  {
    ArrayList<String> result = numdef(n, n);
    return result;
  }
 
  // Driver Code
  public static void main(String[] args)
  {
    // Print all Strobogrammatic
    // number for n = 3
    for (String num : (strobogrammatic_num(4)))
      System.out.print(num + " ");
  }
}

 
// This code is contributed by phasing17