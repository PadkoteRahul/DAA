import java.util.*;

class ClimbingStairs {
	static int ClimbStairs(int n)
	{
		if (n <= 1)
			return n;
		return  ClimbStairs(n-1) + ClimbStairs(n-2);
	}

	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter no of stairs");
		int n = sc.nextInt();
		System.out.println("Number of ways = " + ClimbStairs(n + 1));
	}
}
