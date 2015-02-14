package com.abcdh;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.abcdh.abcd.FirstLevel;

public class abcd {

    public int x = 0;   // data members
    protected int xx=99;        // data members
static int y=100;    // data members
void foo() {
	// TODO Auto-generated method stub
System.out.println("BBBB");
}
  class FirstLevel {  

        public int x = 1;

       final void methodInFirstLevel(int x) {    //member function
            System.out.println("x = " + x);
       //     System.out.println(xx);
            System.out.println("this.x = " + this.x);
       //     System.out.println("ShadowTest.this.x = " + abcd.this.x);
        }
    }

}
   class Temp extends abcd{
    	 public static void main(String[] args) {
    	    	System.out.println(y);
    	    	final int a2= 4;   //local variable
    	    	System.out.println(a2);
    	        abcd st = new abcd();
    //	        st.foo();
    	     aaa sss= new aaa();
    	     sss.foo();
    	        System.out.println(st.xx);
    	    //	FirstLevel fl= new FirstLevel();
    	        abcd.FirstLevel fl = st.new FirstLevel();
    	        fl.methodInFirstLevel(23);
    	    }}
    	 class aaa extends abcd{
    		 @Override
    		public void foo() {
    			// TODO Auto-generated method stub
    			super.foo();
    			System.out.println("HHU");
    		}
    	 }
    


