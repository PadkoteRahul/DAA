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

class LCSdp
{   
	/*
	Time Complexity: O(m * n)
	Space Complexity: O(m * n)
	*/

	public int lcs(char[] c1, char[] c2, int m, int n)  
	{
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) 
		{
            for (int j = 1; j <= n; j++) 
			{
                char ch1 = c1[i - 1];
                char ch2 = c2[j - 1];

				System.out.println("i " + i + " j " + j + " ch1 " + ch1 + " ch2 " + ch2);

                if (ch1 == ch2) 
                    dp[i][j] = 1 + dp[i - 1][j - 1];                
                else 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);                
            }
        }
		System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }
    
	public static void main(String args[])
	{

		// asian always
		// abcde adobe
		// abcde abode
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println(new LCSdp().lcs(s1.toCharArray(),s2.toCharArray(), 
			s1.length(), s2.length()));
	}
}