
public class HelloWorld {
	public static boolean isPalindrom(String s, int start, int end){
		if((end-start)==1||(end-start)==2){
			return true;
		}
		if(s.charAt(start)!=s.charAt(end)){
			return false;
		}
		return isPalindrom(s, start+1, end-1);
	}
	public static void main(String []args){
		String yes = "abcdcba";
		String no = "abbbcd";
		System.out.println(isPalindrom(yes, 0, yes.length()-1));
		System.out.println(isPalindrom(no, 0, no.length()-1));
	}
}
