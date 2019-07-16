/*
Exception handling
-----------------------------------
    Exception: interrupt/stop  the flow of execution

    To handle exception
    -----------------------
        1)try:
        ---------------
            error creation statements

            syntax
            -------------
            try
            {
                //error creation statement

            }
        2)catch
        ----------------------
            take a corrective actions.
                printStackTrace()
                getMessage()

                syntax
                -----------
                catch(ExceptionName variablenam)
                {
                    variablenamed.printStackTrace();

                    //statement
                }


            Exception
            -----------------
            NumberFormatException
            ClassNotFoundException
            ArrayIndexOutOfBoundsException
            FileNotFoundException
*/
import java.util.Scanner;
class ExceptionHandling
{
    public static void main(String ar[])
    {
        Scanner s=new Scanner(System.in);
        int a,b,c;

        System.out.println("Enter two numbers ");
        a=s.nextInt();
        b=s.nextInt();

        c=a/b;
        System.out.println("res is "+c);
        System.out.println("End");

    }

}