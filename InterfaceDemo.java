/*
Interface
--------------------
    is a collection of final data members and abstract member functions.
    access specifier is public.
    "interface" keyword is used.
    can't create an object opf interface.
    support multiple inheritance.
    only signature/declaration of methods.
    interface extends another interface.
    class "implements" the interface.

    syntax
    -------------
    interface interface_name
    {
        //data members
        //member functions
    }


    example
    ---------------
    interface A
    {
        int a=90;
        void disp();
    }

    compiler read :
    -----------------------
        public interface A
        {
            final int a=90;
            abstract void disp();
        }
    
    "implements" interface
    ------------------------------
        class classname implements interface_nam
        {
            //statement
        }


syntax
---------------
interface interface_name
{
    //statement
}
class classname
{
    //statement
}
class classname2 extends classname implements interface_name
{
    //statement
}

or
interface interface_name
{
    //statement
}
interface interface_name2
{
    //statement
}
class classname implements interface_name,interface_name2
{
    //statement
}

or
inteface interface_name
{
    //statement
}
inteface interface_name2 extends interface_name
{
    //statement
}
class classname implements interface_name2
{
    //statement
}

A       B
a       b
   C
   fibonacci series 
*/

interface A
{
    int a=90;
    void disp();
}
interface B extends A
{
    public void disp()
    {
        System.out.println("A is "+a);
    }
}
class InterfaceDemo implements B
{
    public static void main(String ar[])
    {
        B obj=new B();
        obj.disp();

    }
}