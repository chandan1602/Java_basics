/*
class
---------------
    is a collection of data members and member functions.
    "class" keyword.

    syntax
    -----------
    class classname
    {
        //statement

    }

object
-------------
    is an instance of class.
    "new" keyword is used.

    syntax
    ------------
    classname object_name=new classname();

this keyword
------------------
    used to refer a current object.

    syntax
    ------------
    this.variabelname;


example
----------------
class A
{
    int a;
    void get(int a)
    {
        this.a=a;
    }
    void display()
    {
        System.out.println("a is "+a);
    }
}
class ClassDemo
{
    public static void main(String ar[])
    {
        A obj=new A();
        obj.get(45);
        obj.display();
    }
}



Constructor
-------------------
    is a special member function but with no return type.
    is used to initialize an object.
    constructor name same name of the class name.
    its automatically called when an object is created.


    Types
    ---------------
    1)Default constructor
    2)Paramterized Constructor

    1)Default constructor
    --------------------------
        constructor with no arguments

        syntax
        ---------
        clasname/constructor_name()
        {
                //statement

        }

    2)Parameterized constructor
    ------------------------------
        constructor with some arguments.
        we need to pass some arguments while creating an object.
        syntax
        -------------
        classname(arg)
        {
            //statement
        }
*/
class A 
{
    int a;
    A()
    {
        System.out.println("constructor demo");
    }
    A(int x)
    {
        System.out.println("x is "+x);
    }
    void get(int a) {
        this.a = a;
    }

    void display() {
        System.out.println("a is " + a);
    }

/*public void finalize()
    {
        System.out.println("destroy");
    }*/
}

class ClassDemo {
    public static void main(String ar[]) {
        A obj = new A();
        obj.get(45);
        obj.display();
        A obj2=new A(47);
     //   obj.finalize();
       // obj2.finalize();
    }
}