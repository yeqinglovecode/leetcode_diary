class Happiness{
	boolean isHappy(int n){
		HashSet<Integer>cache = new HashSet<Integer>();
		while(cache.add(n)) n = transform(n);
		return (n==1) ? true : false;
	}
	int transform(int n){
		int result = 0;
		while(n!=0){
			result+=(n%10)*(n%10);
			n/=10;
		}
		return result;
	}
}
public class tryplay {
	public static void main(String []args) throws Exception{
		Scanner in = new Scanner(new File("input.txt"));
		try{
			int n = in.nextInt();
			Happiness happiness = new Happiness();
			while(n!=-1){
				System.out.println(happiness.isHappy(n));
				n = in.nextInt();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in!=null) in.close();
		}
	}
}
