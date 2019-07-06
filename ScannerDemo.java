/*
2)Scanner class
---------------------------
    step 1
    ========
      need to import "util" package.

      syntax
      -----------
      import java.util.Scanner;
      or
      import java.util.*;

    step 2
    -------------
        need to create an object of Scanner class.

        syntax
        ------------
        Scanner scanner_object=new Scanner(System.in);

    step 3
    ------------
        read data.

        Methods
        ----------------
        String          next()
        int             nextInt()
        float           nextFloat()
        double          nextDouble()
        char            next().charAt(0)
        String          nextLine()
        byte            nextByte()

        syntax
        ------------
        variablename=scanner_object.method();

example
--------------------

//step 1
import java.util.Scanner;
class  ScannerDemo
{
    public static void main(String ar[])
    {
        //step 2
        Scanner sc=new Scanner(System.in);

        String name;
        int age;

        //step 3
        System.out.print("Enter Name:" );
        name=sc.next();
        System.out.print("Enter Age:" );
        age=sc.nextInt();


        System.out.print("\nName is :"+name+"\nage is :"+age);
        
    }

}
-----------------------------------------------------------------------------------------------------------------------------
    Operators
    -----------------------
        are used to operate on one or more than on operands.

        1)Unary operator
        2)Binary operators
        3)Ternary/conditional operators

        1)Unary operators
        --------------------------
                its work on single operand only.

                1)Increment operator
                    1)Pre-Increment operator
                    ----------------------------------
                            ++i  or i=i+1


                    2)Post-Increment operator
                    ----------------------------
                            i++

                2)Decrement operator

            a=9                 b=6                  
            a++   9               ++b       7
            ++a   11              ++B       8
            ++a   12              --b       7
            a++   12              b--       7
            --a   12              b--       6
            --a   11              ++b       6
            a--   11              b++       6
            ++A   11              b--       7
            a     11               b        6

        2)Binary operators
        ---------------------------------------
            1)Arithmetic operator
            -----------------------
            +       -           *       //      %

            //swapping of two numbers using third variable
            //swapping of two numbers without using third variable
            //sum of three digit number
            //reverse of three digit number

            2)Relational/comparison operators
            -----------------------------------
                used to compare  values.
                
                >       <       <=  >=  !=      ==

            3)Logical operators
            -----------------------
                used to apply logic on two or more than two conditions.

                1)Logical AND operator(&&)
                2)Logical OR operator( || )
                3)Logical NOT operator(!)

    3)Ternary/conditional operator(? :)
    ------------------------------
            its work on three operands.

            syntax
            -----------
            condition?expression1:expression2;

            1)even/odd : if even then return 1 otherwise 0...................."even"  
            2)greatest among three numbers
*/
//step 1
import java.util.Scanner;
class  ScannerDemo
{
    public static void main(String ar[])
    {
        //step 2
        Scanner sc=new Scanner(System.in);

        String name;
        int age;

        //step 3
        System.out.print("Enter Name:" );
        name=sc.next();
        System.out.print("Enter Age:" );
        age=sc.nextInt();


        System.out.print("\nName is :"+name+"\nage is :"+age);
        
    }

}





