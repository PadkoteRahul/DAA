
/* 
Time complexity: O(n)
Space complexity: If we do not consider the size of the stack for function calls then O(1)
otherwise O(h) where h is the height of the tree. 

The height of the skewed tree is n (no. of elements) so the 
worst space complexity is O(n) and height is (Log n) for the balanced tree
so the best space complexity is O(Log n).
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

public class BinaryTreeTraversal 
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

	void inOrderTraversal(BinaryTree node)
    {
        if (node == null)
            return;
  
        // left subtree
        inOrderTraversal(node.left);
		        
		// print val
        System.out.print(node.val + " ");
  
        // right subtree
        inOrderTraversal(node.right);
    }

	void preOrderTraversal(BinaryTree node)
    {
        if (node == null)
            return;

	    // print val
        System.out.print(node.val + " ");
  
        // left subtree
        preOrderTraversal(node.left);
  
        // right subtree
        preOrderTraversal(node.right);
    }

	void postOrderTraversal(BinaryTree node)
    {
        if (node == null)
            return;
  
        // left subtree
        postOrderTraversal(node.left);
  
        // right subtree
        postOrderTraversal(node.right);
  
        // print val
        System.out.print(node.val + " ");
    }

	// 8 10 2 1 5 12 3

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BinaryTreeTraversal btt = new BinaryTreeTraversal();
		
		String str[] = sc.nextLine().split(" ");

		root = new BinaryTree(Integer.parseInt(str[0]));

		for(int i = 1; i < str.length; i++)
			btt.insert(root, Integer.parseInt(str[i]));

		System.out.println("In order Traversal");
		btt.inOrderTraversal(root);										 
		System.out.println("\nPre order Traversal");
		btt.preOrderTraversal(root);
		System.out.println("\nPost order Traversal");
		btt.postOrderTraversal(root);				  
	}
}
