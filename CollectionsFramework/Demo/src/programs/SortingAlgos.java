package programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SortingAlgos {
	public static void main(String[] args) {
		int arr[] = {1,4,2,5,3};
		arr = bubble(arr);
		for(int ele : arr) {
			System.out.print(ele + " ");
		}
		
	}
	
	public static int[] bubble(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}

			}
		}
		return arr;
	}
}
