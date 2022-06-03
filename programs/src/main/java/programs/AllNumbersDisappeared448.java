package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllNumbersDisappeared448 {
    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n) {
            if(nums[nums[i]-1]!=nums[i]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> list = new ArrayList<>();
        for(int j=0; j<n; j++) {
            if(nums[j]-1!=j) list.add(j+1);
        }
        return list;
    }
    
    public static void swap(int arr[], int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}