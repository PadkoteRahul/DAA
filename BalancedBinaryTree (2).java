/*
Mr Rishil is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Anil to check whether BT is a balanced BT or not.
A balanced BT is defined as follows:
- the binary tree in which the left and right subtrees of every node 
differ in height by no more than 1.

Can you help Anil to find and return "true" if the given BT is a balanced tree,
otherwise return "false".

Implement the class Solution:
   1. public boolean isBalanced(BinaryTreeNode root): returns a boolean value.

NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
1 2 3 4 5 -1 -1 6 7

Sample Output-2:
----------------
false


=== testcases ===
case =1
input =2 1 1 2 3 3 2
output =true

case =2
input =1 2 3 4 5 -1 -1 6 7
output =false

case =3
input =1 10 4 3 -1 7 9 12 8 6 -1 -1 2
output =false

case =4
input =2 1 1 2 3 3 2 -1 1 2 3 1 2 3 -1
output =true

case =5
input =1 2 2 3 2 2 3 4 3 2 1 1 2 3 4 8 7 6 5 4 5 6 7 8 7 6 5 4 4 5 6
output =true

case =6
input =1 3 5 7 -1 -1 9 8 -1 -1 -1 -1 -1 -1 6 10 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 13
output =false

case =7
input =1 2 2 3 4 4 3 4 -1 -1 5 -1 5 -1 4 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 8 7 6 5
output =false

case =8
input =1 2 2 3 4 4 3 4 5 -1 6 7 -1 5 4 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 8 7 6 5
output =true

*/

import java.util.*;

class BinaryTree
{
	public int val; 
	public BinaryTree left, right; 
	public BinaryTree(int val){
		this.val = val; 
		left = null; 
		right = null; 
	}
}

public class BalancedBinaryTree
{
	static BinaryTree root;
	void insert(BinaryTree node, int key)
    { 
        if (node == null) {
            node = new BinaryTree(key);
            return;
        }

        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.add(node);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) 
		{
            node = q.remove();
 
            if (node.left == null) {
                node.left = new BinaryTree(key);
                break;
            }
            else
                q.add(node.left);				 
 
            if (node.right == null) {
                node.right = new BinaryTree(key);
                break;
            }
            else
                q.add(node.right);
        }
    }

	public boolean isBalanced(BinaryTree node) 
	{
        if(root == null || root.val == -1){
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(BinaryTree root)
	{
        if(root == null || root.val == -1){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
		System.out.println("left " + left + " right " + right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

	public static void main(String args[])
	{		
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(" ");
		BalancedBinaryTree tree  = new BalancedBinaryTree();
		root = new BinaryTree(Integer.parseInt(str[0]));

		for(int i = 1; i < str.length; i++)
			tree.insert(root,Integer.parseInt(str[i]));

		if (tree.isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");	}
}
