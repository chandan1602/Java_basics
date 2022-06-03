package com.example.restproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestprojectApplicationTests {

	@Test
	void sortRunTest() {
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
