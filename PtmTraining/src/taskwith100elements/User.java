package taskwith100elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class User{
	private int id;
	private String name;
	private String email;
	private String number;
	
	public User() {}
	
	public User(int id, String name, String email, String number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}
	
	public List<User> generateData(int dataCount) {
		List<User> list = new ArrayList<>();
		for(int i=0; i<dataCount; i++) {
			list.add(new User().builder()
					.setId(i)
					.setName("Name"+i)
					.setEmail(String.format("name%d@gmail.com", i))
					.setNumber("0" + ThreadLocalRandom.current().nextInt(10000000, 99999999))
					.build());
		}
		return list;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %d; Name: %s; Email: %s; Number: %s;", id, name, email, number);
	}
	
	public UserBuilder builder() {
		return new UserBuilder();
	}

	public class UserBuilder {
		public UserBuilder setId(int x) {
			id = x;
			return this;
		}
		
		public UserBuilder setName(String s) {
			name = s;
			return this;
		}
		
		public UserBuilder setEmail(String s) {
			email = s;
			return this;
		}
		
		public UserBuilder setNumber(String s) {
			number = s;
			return this;
		}
		
		public User build() {
			return new User(id, name, email, number);
		}
		
	}

}
