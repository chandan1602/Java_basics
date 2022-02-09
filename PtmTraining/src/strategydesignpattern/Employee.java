package strategydesignpattern;

public class Employee {
	private String name;
	private Role role;
	
	public Employee(String name, Role role) {
		this.name = name;
		this.role = role;
	}
	
	public void promote(Role newRole) {
		this.role = newRole;
	}
	
	public String grade() {
		return String.format("%s is a %s", this.name, this.role.description());
	}
	
	public void doWork() {
		System.out.format("%s %s", this.name, this.role.responsibilities());
	}
	
	
}
