package programs;

import java.util.Arrays;

public class SortingAlgos {
    public static void main(String[] args) {
        int arr[] = {1,4,2,5,3};
        System.out.println(Arrays.toString(cyclic(arr)));
    }

    public static int[] bubble(int arr[]) { //inplace -> no extra space; stable->relative order of duplicates same;
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }
            }
            if (!swapped) return arr;
        }
        return arr;
    }

    public static int[] cyclic(int[] arr) {
        int i=0;
        while(i<arr.length) {
            if(arr[i]!=i+1) {
                swap(arr, i, arr[i]-1);
            } else i++;
        }
        return arr;
    }

    public static void swap(int arr[], int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
