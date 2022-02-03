package java8features;

import factoryPatternClasses.Android;
import factoryPatternClasses.OS;
import factoryPatternClasses.OperatingSystemFactory;
import factoryPatternClasses.Windows;

public class E1FactoryMain {
	public static void main(String[] args) {
		//Here Classes Windows and Android are exposed
		//client knows which classes we are working on
		OS obj = new Windows();
		obj.spec();
		OS obj2 = new Android();
		obj2.spec();
		
		//Factory Design Pattern
		OperatingSystemFactory osf = new OperatingSystemFactory();
		OS OBJ = osf.getInstance("Closed");
		OBJ.spec();
	}
}
