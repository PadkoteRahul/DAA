//Knapsack problem
import java.util.*;
class practice
{
    private double maxvalue(item[] arr, int capacity){
        Arrays.sort(arr, new itemsSortcomparator());
        int profit = 0;
        for(item i : arr)
        {
            int curvalue = i.value;
            int curweight = i.weight;
            System.out.println("capacity : "+capacity+"   weight : "+curweight);
            if(capacity - curweight >= 0)
            {
                capacity -= curweight;
                profit += curvalue;
                if(capacity == 0)
                {
                    break;
                }
            }
            else
            {
                int fraction = i.value / i.weight;
                System.out.println("fraction : " + fraction);
                // System.out.println("fraction : " + fraction);
                profit += capacity * fraction;
                capacity = capacity - (capacity * fraction);
            }
            System.out.println("Capacity " + capacity + " totalValue " + profit);

        }

        return profit;
    }
    class itemsSortcomparator implements Comparator
    {
        @Override
        public int compare(Object obj1, Object obj2)
        {
            item i1 = (item)obj1;
            item i2 = (item)obj2;
            double part1 = (double)i1.value/ (double)i1.weight;
            double part2 = (double)i2.value / (double)i2.weight;
            if(part1 < part2)
                return 1;
            else return -1;
        }
    }
    static class item
    {
        int value;
        int weight;
        public item(int d, int w)
        {
            this.value = d;
            this.weight = w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int capacity = sc.nextInt();

        item arr[] = new item[size];
        for(int i=0; i<size; i++)
        {
            arr[i] = new item(sc.nextInt(), sc.nextInt());
        }

        System.out.println(new practice().maxvalue(arr, capacity));

    }
}