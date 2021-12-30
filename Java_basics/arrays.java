/*
Array
-------------------
    is a collection of same type of elements or homogenous type of elements.
    Array is based on index value : 0


    Types of Array
    ---------------------
        1)One dimensional array(1D)
        2)Two dimensional array(2D)
        3)Jagged array

        1)One dimensional 
        -----------------------------
            syntax
            --------------
            datatype arrayname[]=new datatype[size];
            datatype[] arrayname=new datatype[size];
            datatype []arrayname=new datatype[size];
             ex:
            ----
            int a[]=new int[10];

            assign elements
            --------------------
                arrayname[index]=value;

                ex:
                a[0]=89;
                a[1]=34;

            
            syntax
            --------
            datatype arrayname[]={value1,value_n};

            ex:
            --
            int a[]={45,66,69};

            display the elements
            ------------------------
                int i;
                for(i=0;i<=2;i++)
                {

                    System.out.println(a[i]);
                }


//sum of all elements
//print only even numbers
//search element
//sorting : ascending or desc

2)Two dimensional
----------------------------
    syntax
    ------------
    datatype arrayname[][]=new datatype[r_size][c_size];
    or
    datatype []arrayname[]=new datatype[r_size][c_size];
    or
    datatype [][]arrayname=new datatype[r_size][c_size];
    or
    datatype[][] arrayname=new datatype[r_size][c_size];

    ex:
    ---
    int a[][]=new int[10][10];


    a[0][0]=34;
    a[0][1]=44;
    a[1][0]=7;
    a[1][1]=90;
    
    
    assign elements
    --------------------------
         int a[][]={{45,66},{44,6}};

    display element
    ----------------------
        int i,j;
        for(i=0;i<=1;i++)
        {
            for(j=0;j<=1;j++)
            {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println();
        }

A
Am
Ama
Aman

            *
        *       *
    *       *       *
*      *        *        *


//sum of diagonal elements
//matrix mulitiplication
//upper triangular matrix
//lower traingular matrix
//transpose

*/

import java.util.Scanner;

class arrays
{
    public static void main(String ar[]) {
        Scanner sc=new Scanner(System.in);
int i, j, dim, sum=0, search;

System.out.println("Enter the dimensions of matrix : ");
dim=sc.nextInt();
int array[][] = new int[dim][dim];

for(i=0; i<array.length; i++)
{
    for (j=0; j<array.length; j++)
    {
        System.out.println("Enter the element of row : " + i+1 + " column : " + (j+1));
        array[i][j]=sc.nextInt();
    }

    System.out.println();

}

//SUM OF THE ELEMENTS
for(i=0; i<array.length; i++)
{
    for (j=0; j<array.length; j++)
    {
        sum=sum+array[i][j];
    }

}
System.out.println("The sum of the elements is " + sum);


/*
//SUM OF EVEN ELEMENTS
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                if (array[i][j]%2==0) {
                    sum=array[i][j] + sum;
                }
            }

        }
System.out.println("The sum of the even elements is " + sum);
*/


//SEARCHING AN ELEMENT
System.out.println("Enter the element you want to search : ");
search=sc.nextInt();
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                if (array[i][j] == search) {
                    System.out.println("Element found on row : " + (i+1) + " column : " + (j+1));
                }
            }

    }


/*
System.out.println("Enter the number of columns in your 1 dimensional array : ");
dim=sc.nextInt();
int array = new int[dim];
for (i=0; i < dim; i++)
{
    System.out.println("Enter the element number " + (i+1) + " : ");
    array[i]=sc.nextInt();
}
        for (i = 0; i < dim; i++) 

        {

            for (j = i + 1; j < dim; j++) 

            {

                if (array[i] > array[j]) 

                {

                    search = array[i];

                    array[i] = array[j];

                    array[j] = search;

                }

            }

        }

        System.out.print("Ascending Order:");

        for (i = 0; i < dim - 1; i++) 

        {

            System.out.print(array[i] + ",");

        }

        System.out.print(array[dim - 1]);
*/    
    }
}

