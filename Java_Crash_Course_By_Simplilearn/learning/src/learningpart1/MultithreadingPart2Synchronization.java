package learningpart1;
//synchronized keyword puts an intrinsic lock over the object, i.e.,
//only one object can get the hold of the object at a time.

//Scenario 1
//Putting synchronized in front of whole method
class MathOperation {
	synchronized void getMultiples(int n) { 
		for (int i=0; i<=5; i++) {
			System.out.println(n*i);
		try {
			Thread.sleep(400);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		}
	}
}

//Scenario 2
//Putting synchronized in front of specific lines of code causing problems
/*
 * class MathOperation {
	void getMultiples(int n) { 
		synchronized(this) {
		for (int i=0; i<=5; i++) {
			System.out.println(n*i);
		try {
			Thread.sleep(400);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		}
	}
	}
}
 * 
 */


class Thread_1 extends Thread{
	MathOperation mo;
	public Thread_1(MathOperation mo) {
		this.mo = mo;
	}
	public void run() {
		try {
			mo.getMultiples(2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}

class Thread_2 implements Runnable{
	MathOperation mo;
	public Thread_2(MathOperation mo) {
		this.mo = mo;
	}
	public void run() {
		try {
			mo.getMultiples(3);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}



public class MultithreadingPart2Synchronization {
	public static void main(String[] args) {
		MathOperation obj = new MathOperation();
		
		Thread_1 t1 = new Thread_1(obj);
		Thread t2 = new Thread(new Thread_2(obj));
		t1.start();
		t2.start();
	}
}