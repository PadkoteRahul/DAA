/*
Subhani is working with strings. He is given a word W, his task is to form 
special strings. A string said to be special, if the string is formed 
with only one alphabet or one digit.

Print the number of special substrings can be formed using W.

Input Format:
-------------
A string, W consist of digits and lowercase letters.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
abcde

Sample Output-1:
----------------
5


Sample Input-2:
---------------
			

Sample Output-2:
----------------
12

Explanation:
------------
The special strings formed using the word W are:
"aaa","bbb" formed 1 time.
"aa","bb" formed 2 times.
"a","b" formed 3 times.
Total of 12 special strings can be formed.


Sample Input-3:
---------------
binary11100

Sample Output-3:
----------------
15

Explanation:
------------
The special strings formed using the word W are:
"b", "i", "n", "a", "r", "y", "111", "00" formed 1 time
"11", "0" formed 2 times 
"1" formed 3 times


=== testcases ===
case=1
input=aaaba420gaaaaadu143guddddduuuuuflowwwwweeeeerrrrrr
output=118

case=2
input=bbbbbbbbtattarrattatbbbbbbbbtattarrattatbbbbbbbbtattarrattatbbbbbbbbtattarrattat
output=204

case=3
input=mommomom1010001010010101010010101omomomomomomommommomom10101010101000010000010100101omoommomomomo
output=124

case=4
input=aaaaaaafffrrrrrrrrrrrrrrsfdgstryrdhgdghjyfgvdsf
output=162

case=5
input=123456789ohmygoddddddaaaadddddddddyyyyyyyyyyyyyyybabaoiiiiiiiiiii
output=282

case=6
input=nn99qbttxpse
output=15

case=7
input=rrrssrrrcrabomrrmssrmmmkreemmmvalli
output=52

case=8
input=abcabcsbacabcaabcabccaaccabcabcaabacbabaabcababacabacbcabcabcabcbababcacaaabacabcaacacbacbacb
output=103
*/

import java.util.*;

class CountSubstrings 
{    
	/* DP solution
	Time complexity: O(n)
	Space complexity: O(n)
	*/

	public int countLettersDP(String s) 
	{
        int dp[] = new int [s.length()];
        int sum = 1;
		dp[0] = 1;
        
        for(int i = 1; i < s.length(); i++)
		{
            if(s.charAt(i) == s.charAt(i-1))
                dp[i] = dp[i-1] + 1;
			else 
                dp[i] = 1;

			sum += dp[i];
        }        
        return sum;
    }

	// Keep track of the count of same letters, and the total sum
	/* 
	Time complexity: O(n)
	Space complexity: O(1)
	*/

	public int countLetters(String s) 
	{
        int sum = 1;
        int count = 1;
        
        for(int i = 1; i < s.length(); i++)
		{
            if(s.charAt(i) == s.charAt(i-1))
                count++;
			else 
                count = 1;

			sum += count;
        }        
        return sum;
    }

	/* 
	Time complexity: O(n)
	Space complexity: O(1)
	*/
	public int countLetters2(String s) 
	{
        int ans = 0, repeat = 1;

        for (int i = 1; i < s.length(); ++i, ++repeat) 
		{
            if (s.charAt(i) != s.charAt(i - 1)) 
			{	
				// previous char consectively occurs 'repeat' times.
                ans += repeat * (repeat + 1) / 2;
                repeat = 0;
            }
        }
        return ans + repeat * (repeat + 1) / 2;
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		System.out.println(new CountSubstrings().countLetters2(s));
	}
}