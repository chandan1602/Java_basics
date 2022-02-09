package chainofresponsibilitydesignpattern;

public class DivideNumbers implements Chain{
	private Chain nextInChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextInChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalculationMethod()=="divide") {
			System.out.format("%d / %d = %d", request.getNumber1(), request.getNumber2(), request.getNumber1() / request.getNumber2());
		} else {
			System.out.println("No Matching ops found!");
		}
	}

}
