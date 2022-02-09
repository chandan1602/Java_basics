package strategydesignpattern;

public class PrincipalConsultant implements Role{

	@Override
	public String description() {
		return PrincipalConsultant.class.getSimpleName();
	}

	@Override
	public String responsibilities() {
		return "Talks to clients";	
	}
}
