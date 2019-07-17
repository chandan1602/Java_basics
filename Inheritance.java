/*
Inheritance
---------------------
    is used to inherit thr properties of base class to derived class.
    "extends" keyword is used.
    Java does not support multiple inheritance.

    syntax
    -------------
    class Baseclass
    {
        //statement
    }
    class derivedclass extends Baseclass
    {
        //statement
    }

    Types
    -----------------
    1)Single 
    2)Multilevel
    3)Hierarchical inheritance

    1)single Inheritance
    ------------------------------------
    syntax
    -------------
    class Baseclass
    {
        //statement
    }
    class derivedclass extends Baseclass
    {
        //statement
    }

    2)Multilevel inheritance
    -----------------------------------
            A
            |
            B
            |
            c

            syntax
    -------------
    class Baseclass
    {
        //statement
    }
    class derivedclass extends Baseclass
    {
        //statement
    }
    class derivedclass2 extends derivedclass
    {
        //statement
    }

    3)Hierarchical inheritance
    -------------------------------------
    syntax
    -----------------
    class Baseclass{

    }
    class derivedclass extends Baseclass
    {
        //statement
    }
    class derivedclass2 extends Baseclass
    {
        //statement
    }
*/
class A
{
    int a;
    A()
    {
        System.out.println("*********************A*********");
    }
    void getA()
    {
        a=78;
        System.out.println("within A class");
    }
}
class B extends A
{
    int a;
    B()
    {
        super();
    }
    void getA()
    {
        a=90;
    }
    void disp()
    {
        super.getA();
        System.out.println(super.a);
        System.out.println(a);
        
    }
}
class Inheritance
{
    public static void main(String a[])
    {
        B obj=new B();
        obj.getA();
        obj.disp();
    }
}