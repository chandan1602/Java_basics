package example;

public class Abstraction {
	public static void main(String[] args) {
		Audi c1 = new Audi();
		c1.start();
		BMW c2 = new BMW();
		c2.start();
	}	
}

class Audi extends Car{
	
	@Override
	void start() {
		System.out.println("Audi is starting");
	}
	
}

class BMW extends Car{
	@Override
	void start() {
		System.out.println("BMW is starting");
	}
}

abstract class Car { //Objects creation not allowed
	int price;
	
	abstract void start();
}
