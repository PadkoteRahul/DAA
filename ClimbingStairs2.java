import java.util.*;
class ClimbingStairs2
{
	// A recursive function used by countWays
	static int countWays(int n, int m)
	{
		if (n <= 1)
			return n;
		int res = 0;
		for (int i = 1; i <= m && i <= n; i++)
			res += countWays(n - i, m);
		return res;
	}
	
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter total no.of stairs");
		int n = sc.nextInt();
		System.out.println("Enter number of stairs to climb");
		int m = sc.nextInt();
		System.out.println("Number of ways = " + countWays(n + 1, m));
	}
}
