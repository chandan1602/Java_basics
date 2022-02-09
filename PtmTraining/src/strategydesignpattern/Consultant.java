package strategydesignpattern;

public class Consultant implements Role {

	@Override
	public String description() {
		return Consultant.class.getSimpleName();
	}

	@Override
	public String responsibilities() {
		return "Writes Code";
	}
	
}
