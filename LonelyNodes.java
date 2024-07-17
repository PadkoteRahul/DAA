/*
In a joint family, every person assigned with an ID, an integer value.
and the entire family is arranged in the from of tree.

You will be given the family tree,
your task is to find and print the person ID, who is only child to his/her parent.
i.e, the person with no siblings. Print all such person ID's in ascending order.

NOTE: 
	- If only one person is there in the family, please consider him as a parent.
	- In the given tree, please consider '-1' as null.

Input Format:
-------------
Single line of space separated integers, person ID's in the family.

Output Format:
--------------
Print the list of person IDs in ascending order.


Sample Input-1:
---------------
2 3 4 -1 5

Sample Output-1:
----------------
[5]

Sample Input-2:
---------------
11 99 88 77 -1 -1 66 55 -1 -1 -1 -1 -1 -1 44

Sample Output-2:
----------------
[44, 55, 66, 77]

******* Testcases *******
case =1
input =2 3 4 -1 5
output =[5]

case =2
input =11 99 88 77 -1 -1 66 55 -1 -1 -1 -1 -1 -1 44
output =[44, 55, 66, 77]

case =3
input =11 99 88 77 -1 -1 66 55 -1 -1 -1 -1 -1 -1 44 33 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 22
output =[22, 33, 44, 55, 66, 77]

case =4
input =7 1 4 6 -1 5 3 -1 -1 -1 -1 -1 2
output =[2, 6]

case =5
input =31 -1 78 -1 -1 -1 28
output =[28, 78]

case =6
input =76
output =[]

*/

import java.util.*;

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution {
    public ArrayList<Integer> getPersonIDs(BinaryTreeNode root) {
		ArrayList<Integer> nodes = new ArrayList<>();
		getPersonIDs(root, false, nodes); // root is not lonely
		return nodes;
	}
	private void getPersonIDs(BinaryTreeNode root, boolean isLonely, ArrayList<Integer> nodes) {
		if (root == null) return;
		
		if (isLonely && root.data!=-1) {
			nodes.add(root.data);
		}
		
		getPersonIDs(root.left, root.right == null || root.right.data==-1, nodes);
		getPersonIDs(root.right, root.left == null || root.left.data==-1, nodes);
	}
}
public class LonelyNodes{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    {
 
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		LonelyNodes ln=new LonelyNodes();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));
		ArrayList<Integer> result=sol.getPersonIDs(root);
		Collections.sort(result);
		System.out.println(result);
	}
}
