import java.util.*;
import java.util.HashSet;

public class tryplay {
	public static boolean isPalindrome(String str, int l, int r){
		if((r-l)<=0) return true;
		if(str.charAt(l)!=str.charAt(r-1)) return false;
		return isPalindrome(str, l+1, r-2);
	}
	public static String longestPalindrome(String str,int l, int r){
		if(isPalindrome(str,l, r)) return str.substring(l, r);
		while(l<=r){
			//return (longestPalindrome(str,l+1,r)!=null || longestPalindrome(str,l,r-1)!=null) ? 
				//((longestPalindrome(str,l+1,r)!=null) ? longestPalindrome(str,l+1,r) : longestPalindrome(str,l,r-1)) : null;
			String a = longestPalindrome(str,l+1,r);
			String b = longestPalindrome(str,l,r-1);
			if(a!=null && b!=null){
			    //System.out.println(a +" "+b);
				return (a.length()>b.length()) ? a : b;
			}else if(a!=null && b==null){
			    return a;
			}else if(b!=null && a==null){
			    return b;
			}else{
			    return null;
			}
		}
		return new String("a");
		
	}

	public static void main(String []args){
		String a = "cabcdefghgfedcba";
		String b = "bb";
		//System.out.println(isPalindrome(b,0,b.length()-1));
		//System.out.println();
		System.out.println(longestPalindrome(a,0,a.length()));
	}
}

