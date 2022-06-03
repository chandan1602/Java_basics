package programs;

class MissingNumber268 {
    public int missingNumber(int[] nums) {
        //Step1 -> Cyclic Sort
        int n = nums.length;
        int i = 0;
        while(i<n) {
            if(nums[i]==n || i==nums[i]) i++;
            else swap(nums, i, nums[i]);
        }
        for(int j=0; j<n; j++) {
            if(nums[j]!=j) return j;
        }
        return nums.length;
    }
    
    public void swap(int arr[], int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}