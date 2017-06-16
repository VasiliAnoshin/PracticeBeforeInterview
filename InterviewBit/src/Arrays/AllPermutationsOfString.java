package Arrays;

public class AllPermutationsOfString {
	public void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
	 public String swap(String a, int i, int j)
	    {
	        char temp;
	        char[] charArray = a.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
	 
	 	// print n! permutation of the characters of the string s (in order)
	    public  static void perm1(String s) 
	    {
	    	perm1("", s); 
	    }
	    private static void perm1(String prefix, String s) {
	        int n = s.length();
	        if (n == 0){
	        	System.out.println(prefix);
	        }
	        else {
	            for (int i = 0; i < n; i++){
	            	String s1 = s.substring(0, i);
	            	String s2 = s.substring(i+1, n);
	               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
	            }
	        }
	    }
}
