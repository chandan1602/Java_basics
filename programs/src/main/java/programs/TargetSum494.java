package programs;

import java.util.Arrays;

class TargetSum494 {
    //1 -> 1 => 1
    //1 2 -> 1 =>  -1 2
    //1 2 2 -> 1 => 1-2+2, 1+2-2
    public int findTargetSumWays(int[] nums, int target) {
        //pos+neg=sum
        //pos-neg=target
        //2*pos=sum+target

        int sum = 0;
        int zer=0;
        for(int ele: nums) {
            if(ele==0) zer+=1;
            else sum+=ele;
        }

        target+=sum;
        if(target<0 || target%2==1) return 0;

        target/=2;

        if(target==0) return 1<<zer;
        Arrays.sort(nums);

        int ways = dp(nums, target, 0);
        return ways;
    }

    public int dp(int nums[], int target, int ind) {
        if(target==0) return 1;
        if(target<0 || ind==nums.length) return 0;


        int net=0;
        for(int i=ind; i<nums.length; i++) {
            int ele = nums[i];
            int rem = target-ele;
            net += dp(nums, rem, i+1);
        }

        return net;

    }

    public int dp(int nums[], int target, int initSum, int ind) {

        if(ind==nums.length) {
            if(initSum==target) return 1;
            else return 0;
        }

        return dp(nums, target, initSum+nums[ind], ind+1) + dp(nums, target, initSum-nums[ind], ind+1);
    }
    
}