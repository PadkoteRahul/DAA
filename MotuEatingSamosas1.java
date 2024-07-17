/*
Motu loves to eat Samosas. A Samosas vendor prepared N boxes of samosas, 
where i-th box contains box[i] samosas. And the samosas vendor went outside the shop, 
he will be back in T hours time.

Motu can decide his eating speed of samosas per hour as S.  
Each hour, He chooses any box of samosas, and eats S samosas from that box.  
If the box has less than S samosas, he eats all of them instead, 
and won't eat any more samosas during this hour.

Motu likes to eat slowly, but he wants to finish eating all the samosas 
before the vendor come back.

Can you help Motu to find out his minimum eating speed S,
such that he can eat all the samosas within T hours, and print S.

Note:
	- You may assume that the time T is always >= Number of boxes

Input Format:
-------------
Line-1: space separated integers, box[], number of samosas in each box
Line-2: An integer T.

Output Format:
--------------
Print an integer S, minimum eating speed of Motu.


Sample Input-1:
---------------
4 8 9 13
8

Sample Output-1:
----------------
5


Sample Input-2:
---------------
15 18 12 17 22
7

Sample Output-2:
----------------
17


******* Testcases *******
case =1
input =3 6 7 11
8
output =4

case =2
input =6 9 12 13
7
output =7

case =3
input =9 5 7 3 12 8
10
output =6

case =4
input =12 65 43 37 85 73 92 56
35
output =15

case =5
input =9 3 8 6 4 5 7
16
output =3

case =6
input =11 15 18 17 12 14 13 19 16
20
output =9

case =7
input =23 17 18 15 16 26 27
15
output =13

case =8
input =8 5 6 4 9 5 3 7 8 10 12 16 15 18 19 13
23
output =10

*/

import java.util.Scanner;
import java.util.Arrays;

public class MotuEatingSamosas {

	/*
	 * If Motu can finish eating all the Samosas (within H hours) with an eating
	 * speed of S, she can finish with a larger speed too.
	 *
	 * We can use binary search on the values of possible(S) to find the first S such
	 * that possible(S) is True
	 */

	public static int minEatingSpeed(int[] boxes, int T) {
		int low = 1;
		int high = Arrays.stream(boxes).sum();
		System.out.println("Sum " + high);
		
		while (low < high) 
		{
			int mid = (low + high) / 2;

			// If possible continue to search @ lower speed
			if (possible(boxes, T, mid))
				high = mid;
			else // If not possible continue to search @ higher speed
				low = mid + 1;

			System.out.println("low " + low +  " high " + high);
		}
		return low;
	}

	// Can Motu eat all Samosas in H hours with eating speed S?
	public static boolean possible(int[] boxes, int T, int S) {
		int time = 0;
		for (int b : boxes)
		{
			time += (b - 1) / S + 1;
			System.out.println(time + " " + T + " " + S + " " + b);
		}
		return time <= T;
	}

	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");	
		
        int[] boxes = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            boxes[i] = Integer.valueOf(str[i]);
        }
 
		int hours = sc.nextInt();
		System.out.println(minEatingSpeed(boxes, hours));
	}
}
