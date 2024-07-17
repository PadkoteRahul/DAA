/*
Given N satellite stations, numbered 0 to N-1.
These satellites are connected to send signals from one to other.
To send a signal from satellite 's' to satellite 'd', 
it takes an amount of time 't'.

You are given a grid of travel times as times[][], where times[s][d] 
is the value of time 't' required to send a signal from 's' to 'd' or 'd' to 's'

Your task to find the time taken to recieve signal from a satellite station-0 
to all N-1 satellite stations and print them as a list.
i.e. time taken from 0 to 0, time taken from 0 to 1, time taken from 0 to 2,
... , time taken from 0 to N-1.


Input Format:
-------------
Line-1 -> An integer, N number of satellite stations
Next N lines -> N space separated integers, times[][]

Output Format:
--------------
Print the list of integers, times[].


Sample Input-1:
---------------
5
0 6 3 0 0
6 0 2 3 14
3 2 0 3 15
0 3 3 0 10
0 14 15 10 0

Sample Output-1:
----------------
[0, 5, 3, 6, 16]

Sample Input-2:
---------------
6
0 2 4 0 0 0 
2 0 1 7 0 0 
4 1 0 0 3 0
0 7 0 0 2 1
0 0 3 2 0 5
0 0 0 1 5 0

Sample Output-2:
----------------
[0, 2, 3, 8, 6, 9]

3
0 5 0
0 0 6
-20 0 0 

*/

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

class SingleSource {
	// Function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in shortest path tree
	static int V ;
	static int dist[]; 

	int minDistance(int dist[], Boolean visited[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		System.out.println("v\t " + "dist\t " + "visited");
		for (int v = 0; v < V; v++)
		{
			System.out.println(v + "\t " + dist[v] + "\t " + visited[v]);
			if (visited[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		System.out.println("min_index " + min_index);

		return min_index;
	}

	// Function to print the constructed distance array
	void printSolution(int dist[])
	{
		System.out.println(Arrays.toString(dist));
	}

	// Function that implements Dijkstra's single source shortest path
	// algorithm for a graph represented using adjacency matrix 

	int[] dijkstra(int graph[][], int src)
	{
		// The output array will hold the shortest distance from src to i
		dist = new int[V]; 

		// visited[i] is true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean visited[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices not yet processed. 
			// u is always equal to src in first iteration.
			int u = minDistance(dist, visited);

			// Mark the picked vertex as processed
			visited[u] = true;

			// Update dist value of the adjacent vertices of the picked vertex.
			for (int v = 0; v < V; v++)
			{
				// Update dist[v] only if it is not in visited and there is an edge from u to v,
				// and total weight of path from src to v through u is smaller than current value of dist[v]

				if (!visited[v] && graph[u][v] != 0 && 
					dist[u] != Integer.MAX_VALUE && 
					dist[u] + graph[u][v] < dist[v])
				{
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		return dist;
	}

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		V=sc.nextInt();
		int graph[][] = new int[V][V]; 
		for(int i = 0; i < V; i++)
			for(int j = 0;j < V; j++)
				graph[i][j] = sc.nextInt();

		dist = new SingleSource().dijkstra(graph, 0);
		System.out.println(Arrays.toString(dist));
	}
}

/*Test cases
case =1
input =5
0 1 3 15 4
1 0 9 3 14
3 9 0 3 15
15 3 3 0 10
4 14 15 10 0
output ='[0, 1, 3, 4, 4]'

case =2
input =6
0 0 0 9 11 10
0 0 10 5 9 3
0 10 0 5 8 15
9 5 5 0 8 2
11 9 8 8 0 15
10 3 15 2 15 0
output ='[0, 13, 14, 9, 11, 10]'

case =3
input =6
0 6 1 3 3 2
6 0 7 11 15 3
1 7 0 1 3 4
3 11 1 0 5 12
3 15 3 5 0 15
2 3 4 12 15 0
output ='[0, 5, 1, 2, 3, 2]'

case =4
input =7
0 5 2 3 2 12 6
5 0 3 3 4 0 1
2 3 0 3 0 9 3
3 3 3 0 15 8 14
2 4 0 15 0 1 11
12 0 9 8 1 0 0
6 1 3 14 11 0 0
output ='[0, 5, 2, 3, 2, 3, 5]'

case =5
input =8
0 2 10 8 3 10 11 15
2 0 6 0 3 15 12 9
10 6 0 13 6 6 4 8
8 0 13 0 9 10 6 7
3 3 6 9 0 0 0 7
10 15 6 10 0 0 9 12
11 12 4 6 0 9 0 7
15 9 8 7 7 12 7 0
output =[0, 2, 8, 8, 3, 10, 11, 10]

case =6
input =10
0 2 0 10 13 10 1 9 14 8
2 0 14 11 8 13 8 8 14 11
0 14 0 0 0 0 10 10 14 10
10 11 0 0 7 3 0 14 0 0
13 8 0 7 0 15 15 10 7 7
10 13 0 3 15 0 5 1 7 7
1 8 10 0 15 5 0 10 14 11
9 8 10 14 10 1 10 0 0 2
14 14 14 0 7 7 14 0 0 9
8 11 10 0 7 7 11 2 9 0
output ='[0, 2, 11, 9, 10, 6, 1, 7, 13, 8]'

case =7
input =12
0 6 13 1 1 13 10 0 11 5 10 0
6 0 0 3 4 0 8 8 4 3 2 15
13 0 0 9 10 9 9 13 13 1 7 8
1 3 9 10 0 14 8 14 10 13 4 10
1 4 10 2 0 0 6 2 5 9 6 14
13 0 9 14 0 0 3 7 9 13 2 8
10 8 9 8 6 3 0 13 5 2 1 5
0 8 13 14 2 7 13 0 8 3 4 10
11 4 13 10 5 9 5 8 0 8 5 12
5 3 1 13 9 13 2 3 8 0 7 12
10 2 7 4 6 2 1 4 5 7 0 4
0 15 8 10 14 8 5 10 12 12 4 0
output ='[0, 4, 6, 1, 1, 7, 6, 3, 6, 5, 5, 9]'

case =8
input =15
0 5 12 4 4 0 10 14 9 5 6 3 6 15 6
5 0 9 2 9 10 11 3 7 8 7 6 10 10 7
12 9 0 3 8 10 0 6 4 3 6 15 5 3 14
4 2 3 0 1 3 11 15 7 0 9 11 9 9 9
4 9 8 1 0 3 3 11 1 9 6 8 0 5 0
0 10 10 3 3 0 2 6 9 9 2 4 0 6 6
10 11 0 11 3 2 0 8 12 0 0 8 9 13 10
14 3 6 15 11 6 8 0 12 12 2 6 1 4 6
9 7 4 7 1 9 12 12 0 3 10 13 5 4 12
5 8 3 0 9 9 0 12 3 0 3 2 11 1 8
6 7 6 9 6 2 0 2 10 3 0 14 14 11 7
3 6 15 11 8 4 8 6 13 2 14 0 15 6 4
6 10 5 9 0 0 9 1 5 11 14 15 0 7 14
15 10 3 9 5 6 13 4 4 1 11 6 7 0 13
6 7 14 9 0 6 10 6 12 8 7 4 14 13 0
output ='[0, 5, 7, 4, 4, 7, 7, 7, 5, 5, 6, 3, 6, 6, 6]'
*/