package strategydesignpattern;

public class SeniorConsulant implements Role{

	@Override
	public String description() {
		return SeniorConsulant.class.getSimpleName();
	}

	@Override
	public String responsibilities() {
		return "Reviews Code";
	}

}
