// Java program for Kruskal's algorithm to find Minimum Spanning Tree of a given
//connected, undirected and weighted graph

import java.util.*;
import java.lang.*;
import java.io.*;

/*
Time Complexity: O(ElogE) or O(ElogV), Sorting of edges takes O(ELogE) time. 
After sorting, we iterate through all edges and apply the find-union algorithm. 
The find and union operations can take at most O(LogV) time. 
So overall complexity is O(ELogE + ELogV) time. 
The value of E can be at most O(V2), so O(LogV) is O(LogE) the same. 
Therefore, the overall time complexity is O(ElogE) or O(ElogV)

Space Complexity: O(V + E), where V is the number of vertices and 
E is the number of edges in the graph
*/

class KruskalsGraph
{
	// A class to represent a graph edge
	class Edge implements Comparable<Edge>
	{
		int src, dest, weight;

		// Comparator function used for sorting edges based on their weight
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
	};

	// A class to represent a subset for union-find
	class subset
	{
		int parent, rank;
	};

	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all edges

	// Creates a graph with V vertices and E edges
	KruskalsGraph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// A utility function to find set of an element i (uses path compression technique)
	int find(subset subsets[], int i)
	{
		// find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	// A function that does union of two sets of xroot and yroot (uses union by rank)
	void Union(subset subsets[], int xroot, int yroot)
	{
		// Attach smaller rank tree under root of high rank tree (Union by Rank)
		if (subsets[xroot].rank	< subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as root and increment its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// The main function to construct MST using Kruskal's
	// algorithm
	void KruskalMST()
	{
		// This will store the resultant MST
		Edge result[] = new Edge[V];
		
		// An index variable, used for result[]
		int e = 0;
		
		// An index variable, used for sorted edges
		int i = 0;
		for (i = 0; i < V; ++i)
			result[i] = new Edge();

		// Step 1: Sort all the edges in non-decreasing order of their weight. 
		// If we are not allowed to change the given graph, 
		// we can create a copy of array of edges
		Arrays.sort(edge);

		for(i = 0; i < edge.length; i++)
			System.out.println("src " + edge[i].src + " dest " + edge[i].dest + " weight " + edge[i].weight);

		// Allocate memory for creating V subsets
		subset subsets[] = new subset[V];
		for (i = 0; i < V; ++i)
			subsets[i] = new subset();

		// Create V subsets with single elements
		for (int v = 0; v < V; ++v)
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

		// Number of edges to be taken is equal to V-1
		while (e < V - 1)
		{
			// Step 2: Pick the smallest edge. And increment the index for next iteration
			Edge next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			System.out.println("next_edge.src " + next_edge.src + " next_edge.dest " + next_edge.dest + " x " + x + " y " + y);

			// If including this edge doesn't cause cycle, include it in result 
			// and increment the index of result for next edge
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
			// Else discard the next_edge
		}

		// print the contents of result[] to display
		// the built MST
		System.out.println("Following are the edges in "
						+ "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
			System.out.println(result[i].src + " -- "
							+ result[i].dest
							+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree "+ minimumCost);
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		KruskalsGraph graph = new KruskalsGraph(V, E);
		for(int i = 0; i < E; i++)
		{
			graph.edge[i].src = sc.nextInt();
			graph.edge[i].dest = sc.nextInt();
			graph.edge[i].weight = sc.nextInt();
		}

		// Function call
		graph.KruskalMST();
	}
}

/*
Test cases:

case =1
input =4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
output =19

case =2
input =6 12
0 1 4
1 2 5
0 2 4
1 3 3
1 3 7
0 3 6
1 4 7
2 4 8
3 4 3
5 4 8
5 3 7
1 5 9
output =21

case =3
input =4 3
0 1 3
0 2 5
1 3 4
output =12

case =4
input =6 15
0 1 8
0 2 9
0 3 10
0 4 13
0 5 9
1 2 7
1 4 8
1 3 8
5 1 8
2 3 7
2 4 7
5 2 3
2 3 5
3 5 3
4 5 3
output =24

case =5
input =6 15
0 1 16
0 2 15
0 3 14
0 4 18
0 5 19
1 2 7
1 4 6
1 3 11
5 1 8
2 3 3
2 4 15
5 2 9
2 4 8
3 5 7
4 5 5
output =35

case =6
input =8 26
0 1 19
0 2 18
0 3 17
0 4 19
0 5 14
0 7 11
1 2 16
1 3 12
1 4 9
1 5 11
1 6 8
2 3 15
2 4 12
2 5 8
2 6 3
2 7 9
3 4 10
3 5 5
3 6 11
3 7 13
4 5 11
4 6 6
4 7 15
5 6 15
5 7 5
6 7 5
output =43

case =7
input =8 28
0 1 9
0 2 18
0 3 17
0 4 19
0 5 14
0 6 8
0 7 11
1 2 16
1 3 22
1 4 9
1 5 11
1 6 18
1 7 4
2 3 15
2 4 12
2 5 8
2 6 13
2 7 9
3 4 10
3 5 15
3 6 11
3 7 13
4 5 7
4 6 16
4 7 15
5 6 15
5 7 5
6 7 5
output =47

case =8
input =10 44
0 1 9
0 2 18
0 3 17
0 4 19
0 5 14
0 6 8
0 7 11
0 8 14
1 2 16
1 3 22
1 4 9
1 5 11
1 6 18
1 7 4
1 8 16
1 9 9
2 3 15
2 4 12
2 5 8
2 6 13
2 7 9
2 8 14
2 9 7
3 4 10
3 5 15
3 6 11
3 7 13
3 8 8
3 9 18
4 5 7
4 6 16
4 7 15
4 8 9
4 9 10
5 6 15
5 7 5
5 8 12
5 9 9
6 7 5
6 8 14
6 9 8
7 8 11
7 9 14
8 9 12
output =61

*/

