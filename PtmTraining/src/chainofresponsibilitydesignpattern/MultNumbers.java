package chainofresponsibilitydesignpattern;

public class MultNumbers implements Chain{
	private Chain nextInChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextInChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalculationMethod()=="multiply") {
			System.out.format("%d x %d = %d", request.getNumber1(), request.getNumber2(), request.getNumber1() * request.getNumber2());
		} else {
			nextInChain.calculate(request);
		}
	}

}
