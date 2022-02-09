package decoratordesignpattern;

public class Wifi extends FlightSeatDecorator{

	public Wifi(FlightSeat flightSeat) {
		super(flightSeat);
	}
	
	@Override
	public String getFacilities() {
		return this.flightSeat.getFacilities() + "\nWifi";
	}

	@Override
	public Double getCost() {
		return this.flightSeat.getCost() + 10.0;
	}


}
