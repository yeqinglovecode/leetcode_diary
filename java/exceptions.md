#Java Exceptions

##Exception class
		InputStream is = null;
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(is!=null) is.close();
		}
####difference between System.out.println(e);   : details are different 
                and    e.printStackTrace();
Example:
public static void main(String[] args){
    try {
        test();
    } catch (UnsupportedOperationException e) {
        System.out.println(e);
        e.printStackTrace();
    }
}

private static void test() {
    throw new UnsupportedOperationException("Not yet implemented");
}
* With println: you only know what exception has been thrown
java.lang.UnsupportedOperationException: Not yet implemented
* With printStackTrace: you also know what caused it (line numbers + call stack)
java.lang.UnsupportedOperationException: Not yet implemented
at javaapplication27.Test1.test(Test1.java:27)
at javaapplication27.Test1.main(Test1.java:19)
