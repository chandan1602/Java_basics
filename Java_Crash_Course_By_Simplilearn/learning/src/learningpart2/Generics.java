package learningpart2;

//import java.util.ArrayList;
//import java.util.List;

/*
 * 		//Without Generics
		List list = new ArrayList();
		list.add("hello");
		String s = (String) list.get(0);
		System.out.println(s);
		
		//With Generics
		List<String> glist = new ArrayList<String>();
		glist.add("hello generics");
		String gs = glist.get(0);
		System.out.println(gs);
 */


class SingleGenericHolder<T> {
	T obj;
	public SingleGenericHolder(T obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	public T getObject() {
		return this.obj;
	}
}

class DualGenericHolder<T, U> {
	T obj1;
	U obj2;
	public DualGenericHolder(T obj1, U obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void display() {
		System.out.println(obj1);
		System.out.println(obj2);
	}
}


public class Generics {
	public static void main(String[] args) {
		SingleGenericHolder<Integer> iObj = new SingleGenericHolder<Integer>(10);
		System.out.println(iObj.getObject());
		
		SingleGenericHolder<String> sObj = new SingleGenericHolder<String>("Stringify");
		System.out.println(sObj.getObject());
		
		DualGenericHolder<String, Integer> obj = new DualGenericHolder<String, Integer>("Chandan", 13);
		obj.display();
	}
}