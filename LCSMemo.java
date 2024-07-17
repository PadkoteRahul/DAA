/*
Vihaan is given a pair of words: word1 and word2, he is asked to create a method which
returns the numbers of characters in a word formed from long lasting frequent posteriority.
Posteriority is a latest word formed from the native word with few characters removed
without modifying the corresponding order of the left over characters.
A frequent posteriority of two words is a posteriority that is frequent to both words.
Return 0 if no common posteriority.

Input Format:
-------------
Two space separated strings S1, S2.

Output Format:
--------------
Print an integer, the length of longest common subsequence.

Sample Input-1:
---------------
abcde ace

Sample Output-1:
----------------
3

Sample Input-2:
---------------
acd bef

Sample Output-2:
----------------
0


====TestCases====
case =1
input =abcdefghijklmno iamthebeststudentincollege
output =7

case =2
input =abcdefghijklmnopqrstuvwxyz hjkdhowiqjfmaknfeiuwpowrvnkljgopopqwjdknfjbdhjfewg
output =10

case =3
input =cucwxladpycawcvqeoshgmcmpxxvhmtszwxtlkomkdvdcaytzv tyxdbygmehbqeobnxydakrhwztxmdacapiasnfifhlfsutgldhpglikzxbhgtfcjgmedqj
output =17

case =4
input =idckldaiieilfbdaeflhehfadghaldeikehkadeehejklglebf jcbaffgegcjflhgihfgifliflhjcfbagcbkkjagfffkakfclhgbahdfakeihebala
output =20

case =5
input =abcde adobe
output =3

case =6
input =abcdefghijklmnopqrstuvwxyz zyxwvutsrqponmlkjihgfedcba
output =1

case =7
input =nagarjunaisahero cementfactorynamedasnagarjuncements
output =9

case =8
input =abcdefghijklm nopqrstuvwxyz
output =0

*/
import java.util.*;

class LCSMemo
{   
	/*
	Time Complexity: O(m * n)
	Space Complexity: O(m * n)
	*/
	
	static int[][] dp;

	public int lcs(char[] c1, char[] c2, int m, int n) 
	{
		System.out.println("m " + m + " n " + n);
        if (m == 0 || n == 0) 
			return 0;
		
		// if the same state has already been computed
        if (dp[m - 1][n - 1] != 0) {
            return dp[m - 1][n - 1];
        }
		if (c1[m -1 ] == c2[n-1])
			dp[m - 1][n - 1] = 1 + lcs(c1, c2, m-1, n-1); 
		else
			dp[m - 1][n - 1] = Math.max(lcs(c1, c2, m, n-1), lcs(c1, c2, m-1, n)); 

		return dp[m - 1][n - 1];
    }
  
	public static void main(String args[])
	{

		// asian always
		// abcde adobe
		// abcde abode
		Scanner sc = new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		dp = new int[s1.length() + 1][s2.length() + 1];

		System.out.println(new LCSMemo().lcs(s1.toCharArray(),s2.toCharArray(), 
			s1.length(), s2.length()));
	}
}