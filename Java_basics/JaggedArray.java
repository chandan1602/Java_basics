/*
3)Jagged array
---------------------
    here is number of rows are fixed.

    syntax
    ---------------
    datatype arrayname[][]=new datatype[r_size][];

    ex:
    --
    int a[][]=new int[3][];

assign number of columns for each row
----------------------------------------
syntax
--------
    arrayname[r_index]=new datatype[c_size];

    ex:
    ---------
    a[0]=new int[3];
    a[1]=new int[1];
    a[2]=new int[2];

assign elements
---------------------
    arrayname[r_index][c_index]=value;




class JaggedArray
{
    public static void main(String arp[])
    {
        int i,j;
        int a[][]=new int[3][];
        a[0]=new int[3];
        a[1]=new int[1];
        a[2]=new int[2];

        a[0][0]=55;
        a[0][1]=4;
        a[0][2]=6;

        a[1][0]=78;

        a[2][0]=45;
        a[2][1]=89;

        System.out.println("Number of rows: "+a.length);
        System.out.println("Number of cols in 1st row: "+a[0].length);
        
        System.out.println("Array elements");
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a[i].length;j++)
            {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println();
        }
    }

}

example
-------------------

import java.util.Scanner;
class JaggedArray {
    public static void main(String arp[])
    {
        int i,j,r,c,sum=0;
        Scanner s=new Scanner(System.in);

        System.out.print("Enter the num of rows: ");
        r=s.nextInt();

        int a[][]=new int[r][];

        for(i=0;i<a.length;i++)
        {
            System.out.print("Enter Num of cols for "+(i+1)+"=");
            c=s.nextInt();
            a[i]=new int[c];
            sum=sum+c;
        }
        System.out.println("\nEnter "+sum+" Elements ");
        for (i = 0; i < a.length; i++)
        {
            for (j = 0; j < a[i].length; j++) {
                
                a[i][j]=s.nextInt();
            }
        }

        
        System.out.println("\nArray elements");
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a[i].length;j++)
            {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println();
        }
    }

}
*/