package example;

public class Interfaces implements Care {
	public static void main(String[] args) {
		
	}
	
	@Override
	public void start() {
		System.out.println("Starting...");
	}
}



//Diff b/w abstract casses and interfaces
//In A.C -> methods with definition are allowed
//In Interfaces -> only method declarations are allowed

interface Care {
	void start();
//	void notAllowed() { //defining not allowed
//		
//	}
}
