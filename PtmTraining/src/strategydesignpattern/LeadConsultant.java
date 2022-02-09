package strategydesignpattern;

public class LeadConsultant implements Role {

	@Override
	public String description() {
		return LeadConsultant.class.getSimpleName();
	}

	@Override
	public String responsibilities() {
		return "Makes Technical decisions";
	}

}
