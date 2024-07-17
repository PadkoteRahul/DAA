/*
Given N satellite stations, numbered 0 to N-1.
These satellites are connected to send signals from one to other.
To send a signal from satellite 's' to satellite 'd', 
it takes an amount of time 't'.

You are given a list of travel times as times[], where times[i]={s,d,t}
is the value of time 't' required to send a signal from 's' to 'd' or 'd' to 's'

Your task to find the time taken to recieve signal from a satellite station-0 
to all N-1 satellite stations and print them as a list.
i.e. time taken from 0 to 0, time taken from 0 to 1, time taken from 0 to 2,
... , time taken from 0 to N-1.

Note: Use BellmanFord algorithm
If it results in Cyclic, return -1

Input Format:
-------------
Line-1: Two space separated integers N and L,number of Satellite and Satellite links.
Next L lines: Three space separated integers, sourcr (s), destination (d) and time (t)
 
Output Format:
--------------
Print the list of integers, timetaken[].



Sample Input-1:
---------------
5 8     \\N and L
0 1 -1
0 2 4
1 2 3
1 3 3
1 4 2
3 2 5
3 1 1
4 3 -3

Sample Output-1:
----------------
[0, -1, 2, -2, 1]


Sample input 2
------------------
5 9
0 1 -1
0 2 4
1 2 3
1 3 3
1 4 2
3 2 5
3 1 1
3 4 -5
4 3 -3

Sample output 2
----------------
-1

*/
import java.io.*;
import java.lang.*;
import java.util.*;

// A class to represent a connected, directed and weighted Solution
class Solution 
{
	// A class to represent a weighted edge in Graph
	class Edge {
		int src, dest, weight;
		Edge() { 
			src = dest = weight = 0; 
		}
	};

	int V, E;
	Edge edge[];

	// Creates a Graph with V vertices and E edges
	Solution(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// The main function that finds shortest distances from
	// src to all other vertices using Bellman-Ford algorithm. 
	// The function also detects negative weight
	void BellmanFord(Solution solution, int src)
	{
		int V = solution.V, E = solution.E;
		int dist[] = new int[V];

		// Step 1: Initialize distances from src to all other vertices as INFINITE
		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times. shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = solution.edge[j].src;
				int v = solution.edge[j].dest;
				int weight = solution.edge[j].weight;

				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
			//System.out.println("v " + i + " dist[v] " + dist[i]);

		}

		// Step 3: check for negative-weight cycles. The above step guarantees shortest distances
		// if Graph doesn't contain negative weight cycle. If we get a shorter path, then there is a cycle.
		for (int j = 0; j < E; ++j) 
		{
			int u = solution.edge[j].src;
			int v = solution.edge[j].dest;
			int weight = solution.edge[j].weight;

			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
			{
			System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printArr(dist, V);
	}

	void printArr(int dist[], int V)
	{
		System.out.println(Arrays.toString(dist));
	}

	public static void main(String[] args)
	{		
		Scanner sc=new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		Solution solution = new Solution(V, E);
		for(int i = 0; i < E; i++)
		{
			solution.edge[i].src = sc.nextInt();
			solution.edge[i].dest = sc.nextInt();
			solution.edge[i].weight = sc.nextInt();
		}

		// Function call
		solution.BellmanFord(solution, 0);
	}
}
/*test cases:
case =1
input =5 8
0 1 -1
0 2 4
1 2 3
1 3 3
1 4 2
3 2 5
3 1 1
4 3 -3
output ='[0, -1, 2, -2, 1]'


case=2
input=5 9
0 1 -1
0 2 4
1 2 3
1 3 3
1 4 2
3 2 5
3 1 1
3 4 -5
4 3 -3
output =-1

case=3
input=4 4
0 1 3
2 1 -3
3 2 2
0 3 5
output='[0, 3, 7, 5]'

case=4
input=4 4
0 1 3
2 1 -10
3 2 2
0 3 5
output='[0, -3, 7, 5]'
*/