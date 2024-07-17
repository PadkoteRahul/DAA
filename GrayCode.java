/*
Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, 
where two consecutive values in BCS having N bits, must have one bit difference only.
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

=== testcases ===
case =1
input =2
output =[0, 1, 3, 2]

case =2
input =3
output =[0, 1, 3, 2, 6, 7, 5, 4]

case =3
input =4
output =[0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8]

case =4
input =5
output =[0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16]

case =5
input =6
output =[0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16, 48, 49, 51, 50, 54, 55, 53, 52, 60, 61, 63, 62, 58, 59, 57, 56, 40, 41, 43, 42, 46, 47, 45, 44, 36, 37, 39, 38, 34, 35, 33, 32]

case =6
input =7
output =[0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16, 48, 49, 51, 50, 54, 55, 53, 52, 60, 61, 63, 62, 58, 59, 57, 56, 40, 41, 43, 42, 46, 47, 45, 44, 36, 37, 39, 38, 34, 35, 33, 32, 96, 97, 99, 98, 102, 103, 101, 100, 108, 109, 111, 110, 106, 107, 105, 104, 120, 121, 123, 122, 126, 127, 125, 124, 116, 117, 119, 118, 114, 115, 113, 112, 80, 81, 83, 82, 86, 87, 85, 84, 92, 93, 95, 94, 90, 91, 89, 88, 72, 73, 75, 74, 78, 79, 77, 76, 68, 69, 71, 70, 66, 67, 65, 64]

case =7
input =8
output =[0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16, 48, 49, 51, 50, 54, 55, 53, 52, 60, 61, 63, 62, 58, 59, 57, 56, 40, 41, 43, 42, 46, 47, 45, 44, 36, 37, 39, 38, 34, 35, 33, 32, 96, 97, 99, 98, 102, 103, 101, 100, 108, 109, 111, 110, 106, 107, 105, 104, 120, 121, 123, 122, 126, 127, 125, 124, 116, 117, 119, 118, 114, 115, 113, 112, 80, 81, 83, 82, 86, 87, 85, 84, 92, 93, 95, 94, 90, 91, 89, 88, 72, 73, 75, 74, 78, 79, 77, 76, 68, 69, 71, 70, 66, 67, 65, 64, 192, 193, 195, 194, 198, 199, 197, 196, 204, 205, 207, 206, 202, 203, 201, 200, 216, 217, 219, 218, 222, 223, 221, 220, 212, 213, 215, 214, 210, 211, 209, 208, 240, 241, 243, 242, 246, 247, 245, 244, 252, 253, 255, 254, 250, 251, 249, 248, 232, 233, 235, 234, 238, 239, 237, 236, 228, 229, 231, 230, 226, 227, 225, 224, 160, 161, 163, 162, 166, 167, 165, 164, 172, 173, 175, 174, 170, 171, 169, 168, 184, 185, 187, 186, 190, 191, 189, 188, 180, 181, 183, 182, 178, 179, 177, 176, 144, 145, 147, 146, 150, 151, 149, 148, 156, 157, 159, 158, 154, 155, 153, 152, 136, 137, 139, 138, 142, 143, 141, 140, 132, 133, 135, 134, 130, 131, 129, 128]

case =8
input =1
output =[0, 1]

*/

import java.util.*;

class GrayCode {
	public List generateGrayCode(int n) 
	{
        List <String> al = grayCode(n);
        List <Integer> ans = new ArrayList<Integer>();

		// Convert binary code to decimal
        for (String s : al) {
            ans.add(Integer.parseInt(s, 2));
        }
        return ans;
    }

    public List<String> grayCode(int n) {
		List <String> bresult = new ArrayList<String>();
        if (n == 0) {
            bresult.add("0");
            return bresult;
        }
		else if(n == 1)
		{
			bresult.add("0");
			bresult.add("1");
			return bresult;
		}

		// Recursively generate the gray codes of the n-1 bits
		// and then for each of the gray code generated add the prefix 0 and 1.

        List lst = grayCode(n - 1);
        List<String> al = new ArrayList<String>();

		System.out.println("lst " + lst);
        for (int i = 0; i < lst.size(); i++) {
            al.add("0" + lst.get(i));
        }

		System.out.println("al " + al);

        for (int i = lst.size() - 1; i >= 0; i--) {
            al.add("1" + lst.get(i));
        }
        
		System.out.println("n " + n + " al2 " + al);

        return al;
    }

	public static void main( String args[])
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(new GrayCode().generateGrayCode(N));
	}
}