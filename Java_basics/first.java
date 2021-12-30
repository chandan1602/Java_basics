// Java
// ---------------
//     Java is an object-oriented programming language.
//     Java was created James Gosling.
//     Java support Unicode character code.(32 bit ..char 2 bytes)
//     Java is based on compiler as well as on interpreter.
//     Java is case-sensitive language.
//         |
//         A,a both are different.
//     Java is platform-independent language.
//     Java is open-source language.

//     Usages
//     ---------------
//         web application
//         android app development
//         desktop application
//         e-commerce
//         games

// Java software
// ------------------------
//     jdk: Java development kit
//     |
//     jre
//     jvm
//     javac
//     java
//     javap
//     java-rmi

//     editor: notepad/notepad++/brackets
//     save: filename.java
//     compile:   javac filename.java ->.class
//     run:    java filename

//JAR = Java Archive
//      1. - compressed format of a compiled java project

//     source code   -> compiler ->Bytecode
//     .java           javac           .class


//     Bytecode   ->interpreter   ->machine code

//     .class       java            .exe



//     syntax
//     ---------------------
//     class ClassName
//     {
//         public static void main(String variablename[])
//         {
//                 //statement

//         }

//     }


//     Rules fro class ClassName
//     --------------------------------
//         1)always start with capital letter or underscore.
//         2)never starts with number (0-9)
//         3)never uses of special characters execept underscore.
//         4)white spaces are not allowed instead we can use underscore.
//         5)Keywords are not allowed.


//     valid class Name
//     ------------------------
//         FirstDemo
//         _FirstDemo
//         First_Demo
//         First7
//         FirstDemo_

//     invalid class Name
//     ---------------------
//         8First
//         First Demo
//         for
//         %First
//         First@

    
//     Access Specifiers
//     -------------------------
//         1)private: access within class only.
//         2)public: access anywhere in the class.
//         3)protected: access within class and inherited classes.


//     static
//     --------------
//         without creating an instance we can use it.

//     void 
//     --------------
//         is a return type.
//         empty 

//     main()
//     ------------------
//             main() method.
//             compilation always start from main()

//     (String variablename[]):
//     -------------------------------
//             default type of data is String.
//             used for command line arguments.



/*

Display message
----------------------
	System.out.print("message");

	default package:
	-------------------
		java.lang (package)
		|
		System class
		|
		out static variable
			"out"  is an instance of  "java.io.PrintStream"
						|
						print() method

Escape sequences
--------------------------
\n
\t
\r
\w
\"
\'
\\
\?


********************
	hello
********************
	bye
*********************

Data types
-------------------
	are used to define which type of data.
	|
	int
	float
	char
	double
	long
	String
	boolean 
	byte

Variable
------------------
	is used to store some value.
	
	syntax
	-------------	
	declaration
	----------------
		datatype variablename;

		ex:
		------
		int age;	

	initialize
	-------------
		variablename=value;

		ex:
		--------
		age=90;

	definition
	-------------------
		datatype variablename=value;

		ex:
		-----
		int age=90;

	display the value of variable
	-----------------------------------
		System.out.print(variablename);
		or
		System.out.print("message"+variablename);
		

class FirstDemo
{
	public static void main(String ar[])
	{
		String name="abc";
		int age=45;
		float per=74.3f;

		System.out.println("Name is :"+name);
		System.out.println("Age is :"+age);
		System.out.println("Percentage marks  is :"+per);
		System.out.println("Name is :"+name+"\nAge is "+age);
	}
}


Input from user/read data from user
-----------------------------------------------
	1)Comamnd line arguments
	2)Scanner class
	3)BufferedReader class

	1)command line arguments
	--------------------------------
		string:
		---------
		variablename=ar[index];


		int
		--------
		variabelname=Integer.parseInt(ar[index]);

		float
		--------
		variabelname=Float.parseFloat(ar[index]);


Exception occured during command line arguemnts
=----------------------------------------------------------------------
1)ArrayIndexOutOfBoundsException
--------------------------------------
	when we supply less number of arguments at a run-time.
2)NumberFormatException
-------------------------------------
	supply wrong type of data.
*/


//class MyFirstClass{

// 	public static void main(String args[]){
	
// 		String Name = args[0];
// 		int age = Integer.parseInt(args[1]);
// 		float per = Float.parseFloat(args[2]);

// 		System.out.print("Hello "+Name+" \nYour age is: "+age+"\nYour Percentage is: "+per);
		
// }

// }


class first
{
	public static void main(String ar[])
	{
		String name;
		int age;
		float per;
		int roll;

		name=ar[0];
		age=Integer.parseInt(ar[1]);
		roll=Integer.parseInt(ar[2]);
		per=Float.parseFloat(ar[3]);
		
 		System.out.println("Name is :"+name);
		System.out.println("Age is :"+age);
		System.out.println("Roll number is :" + roll);
		System.out.println("Percentage marks  is :"+per);

		
	}
}


