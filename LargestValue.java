/*
For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we can attach atmost two bulbs to left side,
	  and right side of every bulb in previous level.
	- The empty attachements in each level are indicated with -1. 
	(for example: look in hint)

You will be given the root of the X-Mas Tree,
Your task is to findout the bulb with highest voltage in each level.

Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print the list of voltages.

Sample Input-1:
---------------
2 4 3 6 4 -1 9

Sample Output-1:
----------------
[2, 4, 9]


Sample Input-2:
---------------
3 4 7 7 3 8 4 

Sample Output-2:
----------------
[3, 4, 8]


=== testcases ===
case =1
input =2 4 3 6 4 -1 9
output =[2, 4, 9]

case =2
input =3 4 7 7 3 8 4 
output =[3, 7, 8]

case =3
input =1
output =[1]

case =4
input =1 10 4 3 -1 7 9 12 8 -1 -1 6 2 9 13
output =[1, 10, 9, 13]

case =5
input =1 2 4 3 5 6 9 12 8 14 11 6 2 9 13
output =[1, 4, 9, 14]

case =6
input =5 9 1 3 5 7
output =[5, 9, 7]

case =7
input =11 8 6 1 7 5 6 3 20 18 16 22 10 4 2 17 15 19 12
output =[11, 8, 7, 22, 19]

case =8
input =1 3 5 3 -1 -1 9 8 -1 -1 -1 -1 -1 -1 5 10 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 13
output =[1, 5, 9, 8, 13]

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

public class LargestValue {
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

	public List<Integer> largestValues(BinaryTree root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(BinaryTree root, List<Integer> res, int d){
        if(root == null){
            return;
        }
		// expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
			//or set value
			System.out.println("res.get(d) " + res.get(d) + " root.val " + root.val);
            res.set(d, Math.max(res.get(d), root.val));
        }
		System.out.println("d " + d + " res.size() " + res.size() + " val " + root.val);

        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }

	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		LargestValue larvalue = new LargestValue();
		
		String str[]=sc.nextLine().split(" ");
		root = new BinaryTree(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			larvalue.insert(root,Integer.parseInt(str[i]));

		System.out.println(larvalue.largestValues(root));
	}
}
