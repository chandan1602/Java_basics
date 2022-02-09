package decoratordesignpattern;

public class HeadPhone extends FlightSeatDecorator{

	public HeadPhone(FlightSeat flightSeat) {
		super(flightSeat);
	}

	@Override
	public String getFacilities() {
		return this.flightSeat.getFacilities() + "\nHeadPhones";
	}

	@Override
	public Double getCost() {
		return this.flightSeat.getCost() + 7.0;
	}

}
