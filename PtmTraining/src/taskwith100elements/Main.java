package taskwith100elements;

import java.util.List;
import java.util.Map;

public class Main {
	private static int TASKNUMBER = 4;
	public static int dataCount = 100;
	
	public static void main(String[] args) {
		if(TASKNUMBER==0) {
			List<User> list = new User().generateData(dataCount);
			for(User user: list) {
				System.out.println(user);
			}
		} else if(TASKNUMBER==1) {
			List<Integer> list = new FilterOddNumbers(dataCount).getList();
			for(Integer num: list) {
				System.out.println(num);
			}	
		} else if(TASKNUMBER==2) {
			List<Integer> list = new FilterEvenNumbers(dataCount).getList();
			for(Integer num: list) {
				System.out.println(num);
			}	
		} else if(TASKNUMBER==3) {
			List<String> list = new TransformIntToObject(dataCount).getList();
			for(String num: list) {
				System.out.println(num);
			}	
		} else {
			Map<Integer, String> list = new TransformListToMap(dataCount).getList();
			list.forEach((k,v) -> System.out.println(k + ":" + v));
		}
		
		
	}
}
