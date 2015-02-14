class A extends Thread {
	int x;

	@Override
	public void run() {
		for (x = 1; x < 6; x++) {
			System.out.println("Runnable running " + x);
		}
	}

}



public class Test1 {
	public static void main(String[] args) {
		A a = new A();
		Thread thread = new Thread(a);  // a is sharable to both the threads
		Thread thread2 = new Thread(a);
		thread.start();
		thread2.start();
		
	/*	new Thread(new Runnable() {
			public void run() {
				System.out.println();
			}
		}).start();*/
	}
}


