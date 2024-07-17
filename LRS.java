/*
Charlie Brown is working with strings,
He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

MaxSub is a substring which appears atleast twice in S with Maximum length. 

Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
and print the length of MaxSub. If there is MaxSub, return 0.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, length of MaxSub


Sample Input-1:
---------------
babababba

Sample Output-1:
----------------
5

Explanation: 
------------
The Maximum substring is 'babab' , which occurs 2 times.


Sample Input-2:
---------------
abbbbba

Sample Output-2:
----------------
4

Explanation: 
------------
The Maximum substring is 'bbbb' , which occurs 2 times.


Sample Input-3:
---------------
vignesh

Sample Output-3:
----------------
0


******* Testcases *******
case =1
input =babababba
output =5

case =2
input =abbbbba
output =4

case =3
input =vignesh
output =0

case =4
input =ababababacbabacabcaba
output =7

case =5
input =attitudeandgrattitude
output =8

case =6
input =abbabbabbbababbababbbbbbabaaababbbbbbbababababbabababbabbbbaa
output =10

case =7
input =iamacodericandecodeacodeusingdecodingtechnoques
output =5

case =8
input =abbabbabbabbabbabbabbabbabbabb
output =27

*/

import java.util.*;

class LRS 
{
	/*
	Time complexity: O(n^2)
	Space complexity: O(n)
	*/

	public int longestRepeatingSubstring(String s) 
	{
		int max = 0;
        for(int i = 0; i < s.length(); i++)
		{
			for(int j = i + 1; j < s.length(); j++)
			{
				String val = s.substring(i,j);
				System.out.println("val\t" + val + "\tindexOf(val)\t" + s.indexOf(val) + "\tlastIndexOf(val)\t" + s.lastIndexOf(val));
				if(s.indexOf(val) != s.lastIndexOf(val))
				{
					max = Math.max(max, val.length());
					System.out.println("max " + max);
				}
			}
		}
		return max;
    }
	
	// Time complexity: O(n^2)
	// Space complexity: O(n^2)
	public int longestRepeatingSubstring2(String s) 
	{
        Set<String> hs = new HashSet<>();
        int max = 0;
        
        int i = 0;
        while(i <  s.length()) 
		{
            int j = i + max + 1;
            if (j > s.length()) 
				return max;

            String subStr = s.substring(i, j);

			System.out.println("i " + i + " j " + j + " max " + max + " subStr " + subStr);
             
            if (hs.contains(subStr)) 
			{
                max++;
                hs.clear();
                i = 0;
                continue;
            } 
			else 
			{
                hs.add(subStr);
                i++;
            }            
        }        
        return max;
    }
  
  	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(new LRS().longestRepeatingSubstring(s));
	}

}