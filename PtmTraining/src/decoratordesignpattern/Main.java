package decoratordesignpattern;


//Structural design pattern
//used when we want to modify the object at runtime.
public class Main {
	public static void main(String[] args) {
		FlightSeat mainCabinSeat = new Wifi(new HeadPhone(new LiveTV(new MainCabinSeat())));
		
		System.out.println("Chosen Facilities for your seat:");
		System.out.println(mainCabinSeat.getFacilities());
		System.out.println("Total Cost : "+ mainCabinSeat.getCost());
	}
}
