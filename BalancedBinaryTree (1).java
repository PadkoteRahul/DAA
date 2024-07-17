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
        int lth, rth; // left subtree height, right subtree height
 
        /* If tree is empty then return true */
        if (node == null)
            return true;
 
        /* Get the height of left and right sub trees */
        lth = height(node.left);
        rth = height(node.right);

		System.out.println("lth " + lth + " rth " + rth);
 
        if (Math.abs(lth - rth) <= 1 && isBalanced(node.left) && isBalanced(node.right))
            return true;

        return false;
    }

    /* Height is the number of nodes along the longest path from
       the root node down to the farthest leaf node.
	*/

    int height(BinaryTree node)
    {
        if (node == null)
            return 0;

		System.out.println("height node val " + node.val);
 
        /* If tree is not empty then height = 1 + max of left height and right height */
        return 1 + Math.max(height(node.left), height(node.right));
    }

	void inOrderTraversal(BinaryTree node)
    {
        if (node == null)
            return;
  
        // left subtree
        inOrderTraversal(node.left);
		        
		// print val
        System.out.print(node.val + " ");
  
        // then recur on right subtree
        inOrderTraversal(node.right);
    }

	public static void main(String args[])
	{		
		// 8 10 2 1 5 12 3
		
		root = new BinaryTree(8);
		BalancedBinaryTree tree = new BalancedBinaryTree();
		tree.root = new BinaryTree(8);
		tree.root.left = new BinaryTree(10);
		tree.root.right = new BinaryTree(2);
		tree.root.left.left = new BinaryTree(1);
		tree.root.left.right = new BinaryTree(5);
		// tree.root.right.left = new BinaryTree(12);
		// tree.root.right.right = new BinaryTree(3);
		tree.root.left.left.left = new BinaryTree(25);

		System.out.println("Inorder traversal");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		
        if (tree.isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
	}
}
