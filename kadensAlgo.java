import java.util.*;

class kadensAlgo
{
    // static int findLargestSum(int[] arr, int n)
    // {
    //     int max_so_far = 0;
    //     int max_end_here = 0;
    //     for(int i=0; i<n; i++)
    //     {
    //         max_end_here = max_end_here + arr[i];
    //         if(max_end_here < 0)
    //         {
    //             max_end_here = 0;
    //         }
    //         if(max_so_far < max_end_here )
    //         {
    //             max_so_far = max_end_here;
    //         }
    //     }
    //     return max_so_far;
    // }
    static public int findLargestSum(int[] arr, int n)
    {
        int max_so_far = arr[0];
        int current_sum = arr[0];

        for(int i = 1; i<n; i++)
        {
            current_sum = Math.max(current_sum+arr[i], arr[i]);
            max_so_far = Math.max(max_so_far, current_sum);
        }
        return max_so_far;
    }
    static public int findMergedSum(int[] arr, int low, int mid, int high)
    {
        int lsum = -999;
        int rsum = -999;
        int sum = 0;

        for(int i=mid; i>=low; i--)
        {
            sum = sum + arr[i];
            if (sum > lsum)
            {
                lsum = sum;
            }
        }
        
        sum = 0;
        for(int i = mid+1; i<=high; i++)
        {
            sum = sum+arr[i];
            if(sum > rsum)
            {
                rsum = sum;
            }
        }
        return lsum + rsum;
    }
    static public int findLargestSum(int[] arr, int low, int high)
    {
        // if(low>high)
        // {
        //     return 0; 
        // }
        if(low == high)
        {
            return arr[low];
        }
        int mid = (low+high)/2;
        int lss = findLargestSum(arr, low, mid);
        int rss = findLargestSum(arr, mid+1, high);
        // System.out.println(low+" "+high);
        int css = findMergedSum(arr, low, mid, high);
        
        // return Math.max(lss, rss, css);
        return (lss>rss && lss>css)? lss:(rss>lss && rss > css)? rss : css;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        // int mid = n/2;
        System.out.println(findLargestSum(arr, n));
    }
}