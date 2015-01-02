package com.caoruifeng;

public class TestTry {
	
	public static void main(String[] args) throws Exception {
		testEx2();
	}
	static boolean testEx2() throws Exception{
        boolean ret = true;
        try{
            int b=12;
            int c;
            for (int i=2;i>=-2;i--){
                c=b/i;
                System.out.println("i="+i);
                throw new Exception("aaa");
            }
            return true;
        }catch (java.lang.ArithmeticException e){
            System.out.println("testEx2, catch exception");
            ret = false;
            throw new Exception("aaa");
        }finally{
            System.out.println("testEx2, finally; return value="+ret);
        }
    }
}
