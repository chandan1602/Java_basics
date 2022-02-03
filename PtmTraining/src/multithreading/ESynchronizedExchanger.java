package multithreading;

public class ESynchronizedExchanger {
	public static void main(String[] args) {
		SynchronizedExchangerMain exchanger = 
				new SynchronizedExchangerMain();
		
		Thread t1 = new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						for(int i=0; i<10; i++) {
							exchanger.setObject(""+i);
						}
					}
				}
				);
		
		Thread t2 = new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						for(int i=0; i<10; i++) {
							System.out.println(exchanger.getObject());
						}
					}
				}
				);
		t1.start();
		t2.start();
	}
	
}

class SynchronizedExchangerMain {
	protected Object object = null;
	
	public synchronized void setObject(Object o) {
		this.object = o;
	}
	
	public synchronized Object getObject() {
		return this.object;
	}
	
	public void setObj(Object o){
		synchronized(this) {
			this.object = o;
		}
	}
	
	public Object getObj() {
		synchronized (this) {
			return this.object;
		}
	}
}
