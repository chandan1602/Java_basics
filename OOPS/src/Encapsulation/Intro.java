package Encapsulation;

public class Intro {
	public static void main(String[] args) {
		Laptop l1 = new Laptop();
		l1.setPrice(31);
		System.out.println(l1.getPrice());
	}
	
	public void doWork() {
		System.out.println("working...");
	}
	
}

class Laptop {
	int ram;
	private int price;
	public void setPrice(int price) {
		//check if user is admin
		boolean isAdmin = true;
		if(!isAdmin) {
			System.out.println("You cannot set Price! Not an Admin!");
		} else {
			this.price = price;
		}
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
}

