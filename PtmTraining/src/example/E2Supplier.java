package example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class E2Supplier<T> {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		Supplier<LocalDateTime> s = () -> LocalDateTime.now();
		LocalDateTime time = s.get();
		
		System.out.println(time);
		
		Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
		String time2 = s1.get();
		
		System.out.println(time2);
		
		
		
		//Method 2
		//Returns a Supplier
		E2Supplier<String> obj = new E2Supplier<>();
		List<String> list = obj.supplier().get();
		System.out.println("list is " + list);
		
		
		
		//Method 3
		//Factory method to return a Developer object
		Developer obj2 = factory(Developer::new);
        System.out.println(obj2);

        Developer obj3 = factory(() -> new Developer("mkyong"));
        System.out.println(obj3);
	}
	
    public static Developer factory(Supplier<? extends Developer> s) {

        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));

        return developer;

    }
	
	public Supplier<List<T>> supplier() {
		return ArrayList::new;
	}
}

class Developer {

	String name;
    BigDecimal salary;
    LocalDate start;

    // for factory(Developer::new);
    public Developer() {
    }

    // for factory(() -> new Developer("mkyong"));
    public Developer(String name) {
        this.name = name;
    }
    

    
    // get, set, constructor, toString
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %s; Salary: " + this.salary + "; StartDate: " + this.start, this.name);
	}

}
