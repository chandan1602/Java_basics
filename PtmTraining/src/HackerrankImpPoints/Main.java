package HackerrankImpPoints;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
//    private static int B = sc.nextInt();
//    private static int H = sc.nextInt();
    private static boolean flag = false;
    static {
    	System.out.println("I am in Static Block, I am exectued in the sequence of my appearance");
    };
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		//For taking input of String using nextLine after an int, 
		//you must use a nextLine first so that \n of the integer input is skipped.
		//Example
		//------------------------------------
		//		int a = sc.nextInt();
		//		sc.nextLine();
		//		String s = sc.nextLine();
		//		System.out.println(a);
		//		System.out.println(s);
		

		
		//buffered Reader Example to know the EOF
//        int count = 1;
//        String st = "";
//        while((st=bf.readLine())!=null && st.length()!=0) {
//            System.out.println(count + " " + st);
//            count++;
//        }
		System.out.println("I am in Main, and I have no problem being executed after previous static members");
		
		
		
		Locale indiaLocal = new Locale("en", "IN");
		String india = NumberFormat.getCurrencyInstance(indiaLocal).format(100000);
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(100000);
		System.out.println(india + us);
		
		
		
		int n =20;
		int sum = 0;
        for (int i=1; i<Math.sqrt(n); i++) {
            if(n%i==0) {
                sum += i;
                sum += n/i;
                System.out.format("Total (%d): %d+%d\n", sum, i, n/i);
                
            }
        }
	}
}

