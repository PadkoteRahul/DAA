/*
Indian Army setup some military-camps, sitauted at random places at LAC in Galwan.
There exist a main base camp connected with other base camps as follows:
Each military-camp is connected with atmost two other military-camps.
Each military-camp will be identified with an unique ID,(an integer).

To safeguard all the military-camps, Govt of India planned to setup protective 
S.H.I.E.L.D. Govt of India ask your help to build the S.H.I.E.L.D that should 
enclose all the military camps.

You are given the IDs of the military-camps as binary tree. 
Your task is to find and return the military camp IDs, those are on the edge of 
the S.H.I.E.L.D in anti-clockwise order.

Implement the class Solution:
   1. public List<Integer> compoundWall(BondaryOfBTNode root): returns a boolean value.
  

NOTE:
'-1' in the IDs indicates no military-camp (NULL).


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]


=== testcases ===
case =1
input =2 1 3 6 4 -1 9
output =[2, 1, 6, 4, 9, 3]

case =2
input =5 2 4 7 9 8 1
output =[5, 2, 7, 9, 8, 1, 4]

case =3
input =1
output =[1]

case =4
input =11 2 13 4 25 6 -1 -1 -1 7 18 9 10
output =[11, 2, 4, 7, 18, 9, 10, 6, 13]

case =5
input =1 2 4 3 5 6 9 12 8 14 11 6 2 9 13
output =[1, 2, 3, 12, 8, 14, 11, 6, 2, 9, 13, 9, 4]

case =6
input =5 -1 1 -1 -1 3 6
output =[5, 3, 6, 1]

case =7
input =11 8 6 1 7 5 16 3 20 18 14 22 10 4 2 17 15 19 12
output =[11, 8, 1, 3, 17, 15, 19, 12, 18, 14, 22, 10, 4, 2, 16, 6]

case =8
input =1 3 5 7 -1 -1 9 8 -1 -1 -1 -1 -1 -1 6 10 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 13
output =[1, 3, 7, 8, 10, 13, 6, 9, 5]

*/

import java.util.*;

class BoundaryOfBTNode{
	public int data; 
	public BoundaryOfBTNode left, right; 
	public BoundaryOfBTNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

/*
	1. Print the left boundary in top-down manner. 
	2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts: 
		2.1 Print all leaf nodes of left sub-tree from left to right. 
		2.2 Print all leaf nodes of right subtree from left to right. 
	3. Print the right boundary in bottom-up manner.

	We need to take care of one thing that nodes are not printed again. 
	e.g. The left most node is also the leaf node of the tree.
*/

public class BoundaryOfBT
{
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> compoundWall(BoundaryOfBTNode root) 
	{
        if(root == null || root.data==-1) return nodes;

        nodes.add(root.data);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }

    public void leftBoundary(BoundaryOfBTNode root) 
	{
        if((root == null || root.data==-1)|| 
			((root.left == null || root.left.data==-1)
			&& (root.right == null||root.right.data==-1)))
			return;

		System.out.println("Left " + root.data);

        nodes.add(root.data);
        if(root.left == null||root.left.data==-1) 
			leftBoundary(root.right);
        else 
			leftBoundary(root.left);
    }

    public void rightBoundary(BoundaryOfBTNode root) 
	{	
		if((root == null ||root.data==-1)|| 
			((root.left == null ||root.left.data==-1)
			&& (root.right == null||root.right.data==-1))) 
			return;
		
		System.out.println("Right " + root.data);

        if(root.right == null || root.right.data==-1)
			rightBoundary(root.left);
        else rightBoundary(root.right);
			nodes.add(root.data); // add after child visit(reverse)
    }

    public void leaves(BoundaryOfBTNode root) 
	{
        if(root == null || root.data==-1) 
			return;
				
		System.out.println("leaves " + root.data);

        if((root.left == null || root.left.data==-1)
			&& (root.right == null||root.right.data==-1)) 
		{
			System.out.println("leaves node added " + root.data);
            nodes.add(root.data);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

	static BoundaryOfBTNode root;
	static BoundaryOfBTNode temp = root;
	void insert(BoundaryOfBTNode temp, int key)
    {
 
        if (temp == null) {
            root = new BoundaryOfBTNode(key);
            return;
        }
        Queue<BoundaryOfBTNode> q = new LinkedList<BoundaryOfBTNode>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new BoundaryOfBTNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BoundaryOfBTNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str[]=sc.nextLine().split(" ");
		BoundaryOfBT bt = new BoundaryOfBT();
		root = new BoundaryOfBTNode(Integer.parseInt(str[0]));

		for(int i=1; i<str.length; i++)
			bt.insert(root,Integer.parseInt(str[i]));

		BoundaryOfBT obj = new BoundaryOfBT();
		System.out.println(obj.compoundWall(root));
	}
}