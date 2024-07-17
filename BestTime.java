/*
Sachin wants to try his luck in diamonds business. 
He decides to purchase and sell one diamond. 

He is given the list of price of one diamond for N days by his friend.
Initially, it is assumed that he has no diamonds.
 
You need to help Sachin in making the maximum profit that is possible. 
He can sell the diamond only after he purchases it. 

Note: He is allowed to do only one complete transaction	
(purchase one diamond and sell it).
   
Input Format:
-------------
Line-1:N represents the number of diamonds.
Line-2:N-space separated integers, price of the diamond for N days.

Output Format:
--------------
Print an integer, maximum profit.
 
Sample Input-1:
---------------
6
7 1 5 3 6 4
 
Sample Output-1:
----------------
5
 
Explanation: 
------------
Purchase on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 

Sample Input-2:
---------------
5 
7 6 5 4 2
 
Sample Output-2:
----------------
0
*/

import java.util.*;

class BestTime {
	public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;

			System.out.println("minPrice " + minprice + " maxprofit " + maxprofit);
        }
        return maxprofit;
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		ar[i]=sc.nextInt();
		System.out.println(new BestTime().maxProfit(ar));
	}
}


/*
Test cases:
case =1
input =6
7 1 5 3 6 4
output =5
 
case =2
input =5
7 6 5 4 2
output =0
 
case =3
input =10
37 14 21 87 82 75 15 46 73 22
output =73

case =4
input =15
81 83 81 65 39 77 12 60 13 8 45 37 85 24 34
output =77

case =5
input =25
37 14 21 87 82 75 15 46 73 22 81 83 81 65 39 77 12 60 13 18 45 37 96 24 34
output =84
 
case =6
input =40
88 174 186 52 162 158 173 110 129 116 120 116 66 187 82 62 167 116 182 180 183 155 63 130 18 116 177 155 64 117 44 27 135 174 148 56 79 25 139 16
output =159
 
case =7
input =50
30 12 16 57 90 48 42 16 29 103 66 90 62 92 87 75 87 74 4 36 47 131 53 43 26 41 28 75 114 70 134 147 5 49 113 2 76 73 35 150 31 94 120 109 72 126 137 126 75 146
output =148
 
case =8
input =6
3 1 8 200 100 7
output =199
*/



