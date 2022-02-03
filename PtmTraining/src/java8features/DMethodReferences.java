package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DMethodReferences {
	public static void main(String[] args) {
		//Method References are represented by:
		//:: operator
		
		List<String> list = Arrays.asList("node", "java", "python", "ruby");
		
		//Scenario 1
		System.out.println("Scenario 1");
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.println(str);
			}
		});
		
		//Scenario 2
		System.out.println("Scenario 2");
		list.forEach(str -> System.out.println(str));
		
		//Scenario 3
		System.out.println("Scenario 3");
		list.forEach(System.out::println);
		
		
		//Method reference provides better readability
		//Four kinds of method reference:
		//1. ClassName::staticMethodName
		//2. Object::instanceMethodname
		//3. ContainingType::methodName
		//4. ClassName::new
		
		
		
		
		//1. Static method
		//By Anonymous class
		//By Lambda: (x) -> ClassName.staticMethodName(x)
		//By Method Reference: ClassName.staticMethodName
		
		//anonymous class
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String x) {
				SimplePrinter.print(x);
			}
		});
		//lambda
		System.out.println("Overriding static by lambda");
		list.forEach(x -> SimplePrinter.print(x));
		
		//method reference
		System.out.println("Overriding static by method ref");
		list.forEach(SimplePrinter::print);
		
		
		
		
		
		
		//Method 2
		//Instance method
		List<Employee> list2 = Arrays.asList(
                new Employee("mkyong", 38, 3800),
                new Employee("zilap", 5, 100),
                new Employee("ali", 25, 2500),
                new Employee("unknown", 99, 9999));

        // anonymous class
        /*list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return provider.compareBySalary(o1, o2);
            }
        });*/

        ComparatorProvider provider = new ComparatorProvider();

        // lambda
        // list.sort((o1, o2) -> provider.compareBySalary(o1, o2));

        // method reference
        list2.sort(provider::compareBySalary);

        list2.forEach(System.out::println);
		
        
        
        
        
        
        
        //Method 3
        //Lambda

        //arg0 is the first element
//        (argo, rest_of_args) -> argo.methodName(rest_of_args)
//        (a,b) -> a.compareToIgnoreCase(b)
        
        //Method Reference
        
        //first argument type
//        arg0_Type::methodName
        //arg0 is type of ClassName
//        ClassName::methodName
        //example, a is a type of string
//        String::compareToIgnoreCase
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        
  
        
        
		
	}
}

class SimplePrinter {
	public static void print(String str) {
		System.out.print(str + " ");
	}
}

class Employee {
	protected String name;
	protected int age;
	protected int salary;
	Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	Integer getAge() {
		return this.age;
	}
	String getName() {
		return this.name;
	}
	Integer getSalary() {
		return this.salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %s; Age: %d; Salary:%d;", this.name, this.age, this.salary);
	}
}

class ComparatorProvider {

    public int compareByAge(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

    public int compareByName(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareBySalary(Employee o1, Employee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }

}