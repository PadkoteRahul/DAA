import java.util.*;

class LCP_HM
{
	public static String getsmallstring(String a[]){
		String x = a[0];
		int min = x.length();

		for(int i = 1; i < a.length; i++){
			int tl=a[i].length();
			if(tl < min){
				min = tl;
				x = a[i];
			}
		}
		return x;
	}

    public static String longestcommonprefix(String a[]){
        String small = getsmallstring(a);
        Map<Character,Integer> m = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<small.length(); i++){
            m.put(small.charAt(i),0);
            for(int j=0; j<a.length; j++){
                m.put(a[j].charAt(i), m.getOrDefault(a[j].charAt(i),0)+1);
            }

			// If the character occurs as many times as the length of the smallest string, 
			// append to stringbuilder
            if(m.get(small.charAt(i))==a.length){
                sb.append(small.charAt(i));
            }
			else
				break;
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String a[]=sc.nextLine().split(" ");
        System.out.print(longestcommonprefix(a));
    }
}