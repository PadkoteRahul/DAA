/*
Ramesh is interested to work on Data Structures.
He has constructed BinaryTree-BT.

He asked his friend Gopal to check whether BT is self mirror tree or not.
Can you help Gopal to find and return "true" if BT is a self mirror tree,
otherwise return "false"

Implement the class Solution:
   1. public boolean isSelfMirrorTree(BinaryTreeNode root): returns a boolean value.
  
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
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false


******* Testcases *******
case =1
input =2 1 1 2 3 3 2
output =true

case =2
input =2 1 1 -1 3 -1 3
output =false

case =3
input =2 1 1 -1 3 3 -1 -1 -1 -1 3 3 -1 -1 -1
output =true

case =4
input =2 1 1 2 3 3 2 -1 1 2 3 1 2 3 -1
output =false

case =5
input =1 2 2 3 2 2 3 4 3 2 1 1 2 3 4 8 7 6 5 4 5 6 7 7 6 5 4 5 6 7 8
output =true

case =6
input =1 2 2 3 2 2 3 4 3 2 1 1 2 3 4 8 7 6 5 4 5 6 7 8 7 6 5 4 4 5 6
output =false

case =7
input =1 2 2 3 4 4 3 4 -1 -1 5 -1 5 -1 4 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 8 7 6 5
output =false

case =8
input =1 2 2 3 4 4 3 4 5 -1 -1 -1 -1 5 4 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 8 7 6 5
output =true

*/


import java.util.*;

class BinaryTree{
	public int val; 
	public BinaryTree left, right; 
	public BinaryTree(int val){
		this.val = val; 
		left = null; 
		right = null; 
	}
}

public class SymmetricTree
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

	public boolean isSymmetric(BinaryTree root)
	{
        return root==null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(BinaryTree left, BinaryTree right)
	{
        if(left==null || right==null)
            return left == right;
        if(left.val != right.val)
            return false;
        return isSymmetricHelper(left.left, right.right) && 
			isSymmetricHelper(left.right, right.left);
    }

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(" ");
		SymmetricTree st = new SymmetricTree();

		root = new BinaryTree(Integer.parseInt(str[0]));
		for(int i = 1; i < str.length; i++)
			st.insert(root, Integer.parseInt(str[i]));

		System.out.println(st.isSymmetric(root));
	}
}