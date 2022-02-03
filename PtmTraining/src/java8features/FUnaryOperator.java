package java8features;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

//Unary Operator takes one argument, and 
//returns a result of the same type of its arguments

public class FUnaryOperator {
	public static void main(String[] args) {
		//Example 1:
		//Function is a functional interface, that 
		//takes in one type of arg and returns another
		//type of arg
		Function<Integer, Integer> func = x -> x*2;
		Integer result = func.apply(2);
		System.out.println(result);
		//Function can be replaced with UnaryOperator
		//when return and arg are of same data types
		UnaryOperator<Integer> func2 = x -> x*2;
		Integer result2 = func2.apply(2);
		System.out.println(result2);
		//NOTES:
		//1. Similarly BinaryOperator takes two args of same type and
		//returns result of same type
		
		//2. when only working with int, use IntBinaryOperator for 
		//better performance.
		
		
		
		//Example 2
		//Unary Operator as an argument
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> result3 = math(list, x -> x*2);
		System.out.println(result3);
		
		
		//Example 3
		//Chain Unary Operator
		//For Chain Function we use
		//Syntax
		//----------
		/*
		Function<String, Integer> funcx = x -> x.length();
		Function<Integer, Integer> funcy = x -> x*2;
		Integer resultx = funcx.andThen(funcy).apply("Chandan");
		System.out.println(resultx);
		*/
		List<Integer> result4 = math(list, x -> x*2, x->x+1);
		System.out.println(result4);
		
		
		
		//Example of BinaryOperator ::maxBy, ::minBy
	      DeveloperX dev1 = new DeveloperX("jordan", BigDecimal.valueOf(9999));
	        DeveloperX dev2 = new DeveloperX("jack", BigDecimal.valueOf(8888));
	        DeveloperX dev3 = new DeveloperX("jaden", BigDecimal.valueOf(10000));
	        DeveloperX dev4 = new DeveloperX("ali", BigDecimal.valueOf(2000));
	        DeveloperX dev5 = new DeveloperX("mkyong", BigDecimal.valueOf(1));
	        
		List<DeveloperX> listX = Arrays.asList(dev1, dev2, dev3, dev4, dev5);
		//Creating a Comparator
		Comparator<DeveloperX> comparing = Comparator.comparing(DeveloperX::getSalary);
		//BinaryOperator with a custom comparator
		BinaryOperator<DeveloperX> bo = BinaryOperator.maxBy(comparing);
		BinaryOperator<DeveloperX> bo2 = BinaryOperator.minBy(comparing);
		DeveloperX resultX = find(listX, bo);
		DeveloperX resultY = find(listX, bo2);
		System.out.println(resultX);
		System.out.println(resultY);
		
		
		
	}
	
	public static <T> List<T> math(List<T> list, UnaryOperator<T> uo) {
		List<T> result = new ArrayList<T>();
		for (T t: list) {
			result.add(uo.apply(t));
		}
		return result;
	}
	
	public static <T> List<T> math(List<T> list, UnaryOperator<T> uo, UnaryOperator<T> uo2) {
		List<T> result = new ArrayList<T>();
		for (T t: list) {
			result.add(uo.andThen(uo2).apply(t));
		}
		return result;
	}
	
	   public static DeveloperX find(List<DeveloperX> list, BinaryOperator<DeveloperX> accumulator) {
	        DeveloperX result = null;
	        for (DeveloperX t : list) {
	            if (result == null) {
	                result = t;
	            } else {
	                result = accumulator.apply(result, t);
	            }
	        }
	        return result;
	    }
}


class DeveloperX {
	String name;
	BigDecimal salary;
	
	public DeveloperX(String name, BigDecimal salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s earns " + this.salary, this.name);
	}

	public String getName() {
		return name;
	}

	public BigDecimal getSalary() {
		return salary;
	}
}
