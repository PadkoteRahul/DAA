import java.util.*;

class printRemainingLadduss
{
    public static void printRemainingLaddus(int k, int s, int e, int[] arr)
    {
        int start = arr[0]-s;
        if(start != 0)
        {
            if(start == 1)
            {
                System.out.print("["+(arr[0]-1));
            }
            else
                System.out.print("["+s+":"+(arr[0]-1)+", ");
        }
        else 
        {
            System.out.print("[");
        }
        for(int i=1; i<k; i++)
        {
            if((arr[i]-arr[i-1]) == 2) 
            {
                System.out.print(arr[i]-1+", ");
            }
            else if((arr[i]-arr[i-1]) > 1)
            {
                System.out.print((arr[i-1]+1)+":"+(arr[i]-1)+", ");
            }
        }
        if(e - arr[k-1] != 1)
        {
            System.out.print((arr[k-1]+1)+":"+e+"]");
        }
        else
            System.out.print("]");
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int s = sc.nextInt();
        int e = sc.nextInt();
        
        int[] arr = new int[k];
        for(int i=0; i<k; i++)
        {
            arr[i] = sc.nextInt();
        }
        printRemainingLaddus(k, s, e, arr);
    }
}