/*
Budget Padmanabham planned to visit the tourist places.
There are N tourist places in the city.
The tourist places are numbered from 1 to N.
You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.

Your task is to help Budget Padmanabham to find the cheapest route plan,
to visit all the tourist places in the city. If you are not able to find such plan, print -1.

Input Format:
-------------
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
 
Output Format:
--------------
Print an integer, minimum cost to visit all the tourist places.


Sample Input-1:
---------------
4 5
1 2 3
1 3 5
2 3 4
3 4 1
2 4 5

Sample Output-1:
----------------
8

Explanation:
------------
The cheapest route plan is as follows:
1-2, 2-3, 3-4 and cost is 3 + 4 + 1 = 8


Sample Input-2:
---------------
4 3
1 2 3
1 3 5
2 3 4

Sample Output-2:
----------------
-1
*/

import java.util.*;

class SpanningTree {    
    int[] parent;
    int n;
    
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

		System.out.println("Union x " + x + " y " + y + " px " + px + " py " + py);
        
        if (px != py) {
            parent[px] = py;
            n--;
        }
    }
    
    private int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
		System.out.println("find x " + x + " parent[x] " + parent[x]);

        parent[x] = find(parent[x]); // path compression

        return parent[x];
    }
    
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N + 1];
        n = N;
		System.out.println("parent");
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
			System.out.print(parent[i] + " ");
        
        }
		System.out.println();
        
		// We sort on weight, index 2 of the edge (0 - start, 1 - end, 2 - weight)
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

		System.out.println();
		for(int i = 0; i < connections.length; i++)
		{
			System.out.println(connections[i][0] + " " + connections[i][1] + " " + connections[i][2]);
		}
        
        int res = 0;
        
        for (int[] c : connections) {			
            int x = c[0], y = c[1];
            if (find(x) != find(y)) {
                res += c[2];
                union(x, y);
            }
        }
        
        return n == 1 ? res : -1;
    }
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int edges[][]=new int[e][3]; 
		for(int i=0;i<e;i++)
			for(int j=0;j<3;j++)
				edges[i][j]=sc.nextInt();
		System.out.println(new SpanningTree().minimumCost(n,edges));
	}
}

/*
Test cases:

case =1
input =4 5
1 2 3
1 3 5
2 3 4
3 4 1
2 4 5
output =8

case =2
input =6 12
1 2 4
2 3 5
1 3 4
2 4 3
3 4 7
1 4 6
2 5 7
3 5 8
4 5 3
6 5 8
6 4 7
2 6 9
output =21

case =3
input =4 3
1 2 3
1 3 5
2 3 4
output =-1

case =4
input =6 15
1 2 8
1 3 9
1 4 10
1 5 13
1 6 9
2 3 7
2 5 8
2 4 8
6 2 8
3 4 7
3 5 7
6 3 3
4 5 5
4 6 3
5 6 3
output =24

case =5
input =6 15
1 2 16
1 3 15
1 4 14
1 5 18
1 6 19
2 3 7
2 5 6
2 4 11
6 2 8
3 4 3
3 5 15
6 3 9
4 5 8
4 6 7
5 6 5
output =35

case =6
input =8 26
1 2 19
1 3 18
1 4 17
1 5 19
1 6 14
1 8 11
2 3 16
2 4 12
2 5 9
2 6 11
2 7 8
3 4 15
3 5 12
3 6 8
3 7 3
3 8 9
4 5 10
4 6 5
4 7 11
4 8 13
5 6 11
5 7 6
5 8 15
6 7 15
6 8 5
7 8 5
output =43

case =7
input =8 28
1 2 9
1 3 18
1 4 17
1 5 19
1 6 14
1 7 8
1 8 11
2 3 16
2 4 22
2 5 9
2 6 11
2 7 18
2 8 4
3 4 15
3 5 12
3 6 8
3 7 13
3 8 9
4 5 10
4 6 15
4 7 11
4 8 13
5 6 7
5 7 16
5 8 15
6 7 15
6 8 5
7 8 5
output =47

case =8
input =10 44
1 2 9
1 3 18
1 4 17
1 5 19
1 6 14
1 7 8
1 8 11
1 9 14
2 3 16
2 4 22
2 5 9
2 6 11
2 7 18
2 8 4
2 9 16
2 10 9
3 4 15
3 5 12
3 6 8
3 7 13
3 8 9
3 9 14
3 10 7
4 5 10
4 6 15
4 7 11
4 8 13
4 9 8
4 10 18
5 6 7
5 7 16
5 8 15
5 9 9
5 10 10
6 7 15
6 8 5
6 9 12
6 10 9
7 8 5
7 9 14
7 10 8
8 9 11
8 10 14
9 10 12
output =61
*/

