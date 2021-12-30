//EXECUTION COMMANDS
//javac median.java
//java median

import java.util.*;

class median {
    static int[] recurse(int arr[], int sol[], int n) {
        if(n < 3) {
            return sol;
        }
        int temp[] = new int[3];
        temp[0] = arr[0];
        temp[1] = arr[(int) n/2];
        temp[2] = arr[n-1];
        Arrays.sort(temp);
        sol = addNumber(sol.length, sol, temp[1]);
        int left[] = {};
        int right[] = {};
        for (int i=0; i<n; i++) {
            if(arr[i] < temp[1]) {
                left = addNumber(left.length, left, arr[i]);
            } else if(arr[i] > temp[1]) {
                right = addNumber(right.length, right, arr[i]);
            }
        }
        sol = recurse(left, sol, left.length);
        sol = recurse(right, sol, right.length);
        return sol;
    }

    public static int[] addNumber(int n, int arr[], int x) {
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Length : ");
        int n = sc.nextInt();
        int array[] = new int[n];
        System.out.print("Enter Array Integers : ");
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        if(n>2) {
            int sol[] = {};
            sol = recurse(array, sol, n);
            for(int i=0; i<sol.length; i++) {
                System.out.println(sol[i]);
            }
        } 
        
    }
}