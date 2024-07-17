import java.util.*;

class SmallestCommonElement{
	private static boolean binarySearch(int[] arr, int low, int high, int target) 
	{
		System.out.println("target " + target);
        while(low <= high) {
            int mid = (low + high)/2; 
            if(arr[mid] == target) {
                return true;     
            } else if(arr[mid] < target) {
                low = mid+1; 
            } else {
                high = mid-1; 
            }
        }    
        return false; 
    }
    
    public static int smallestCommonElement(int[][] mat) {
        if(mat.length == 1) return mat[0][0]; 

		// Get each element of array 1. Compare with each element of remaining array elements
        for(int ele : mat[0]) {
            int count = 0; 
            for(int i = 1; i < mat.length; i++) {
                if(binarySearch(mat[i], 0, mat[i].length-1, ele)) {
                    count++; 
                } else {
                    break; 
                }
            }
			System.out.println("Count " + count);
            if(count == mat.length -1) return ele; 
        }
        return -1; 
    }

	public static void main(String[] args) { 
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] arr = new int[m][n]; 

		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println(smallestCommonElement(arr)); 
	} 
}