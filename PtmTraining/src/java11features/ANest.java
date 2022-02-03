package java11features;

//Nest Based access control
//supports private access within nest members


public class ANest {
	
	private String name;
	private String email;
	
	public ANest() {}
	
	public ANest(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("name : %s; email: %s;", name, email);
	}

	public String getName() {
		return name;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public BuildANest builder() {
		return new BuildANest();
	}
	
	public class BuildANest {
		public BuildANest setName(String s) {
			name = s;
			return this;
		}

		public BuildANest setEmail(String s) {
			email = s;
			return this;
		}
		
		public ANest build() {
			return new ANest(name, email);
		}
	}
	
	public static void main(String args[]) {
		ANest obj = new ANest();
		obj.builder()
			.setEmail("demo@ocltp.com")
			.setName("Demo Name")
			.build();
		System.out.println(obj);
	}

}
