import java.util.*;

// Euclidean algorithm: GCD of two numbers doesn't change if 
// smaller number is subtracted from larger number

public class GCD 
{
	public static int calculateGCD(int a, int b)
	{
		//If both the number are equal
		if (a == b) 
			return a;
		else if (a == 0) 
			return b;
		else if (b == 0) 
			return a;
		else if (a > b) 
		{
			return calculateGCD(a - b, b);
		} else {
			return calculateGCD(a, b - a);
		}
	}
 
	// public static int calculateGCD(int a, int b)
	// {
	// 	if( b == 0) return a;
	// 	return calculateGCD(b, a%b);
	// }
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first number");
		int n1 = in.nextInt();
		System.out.println("Enter second number");
		int n2 = in.nextInt();
		System.out.println(calculateGCD(n1, n2));
     } 
}

