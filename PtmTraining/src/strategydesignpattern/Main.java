package strategydesignpattern;


//Where object has a dynamic behaviour which can change at runtime
//
public class Main {
	public static void main(String[] args) {
		Employee ram = new Employee("Ram", new Consultant());
		Employee arjun = new Employee("Arjun", new SeniorConsulant());
		
		System.out.println("-------Before promotion-------\n");
		
		ram.doWork();
		arjun.doWork();
		
		ram.promote(new  SeniorConsulant());
		arjun.promote(new LeadConsultant());
		
		System.out.println("\n-------After promotion-------\n");
		
		ram.doWork();
		arjun.doWork();
	}
}
