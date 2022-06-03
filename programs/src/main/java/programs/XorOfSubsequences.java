package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class XorOfSubsequences {
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> res = traverse(nums, 0);
        System.out.println(res);
        int sum=0;
        for(List<Integer> ele: res) {
            int xor = 0;
            for(Integer num: ele) {
                xor^=num;
            }
            sum+=xor;
        }
        return sum;
    }
    
    public static List<List<Integer>> traverse(int[] arr, int i) {
        if(arr.length==0) {
            List<List<Integer>> sol = new ArrayList<>();
            sol.add(new ArrayList<>());
            return sol;
        }
        
        int curr = arr[0];
        int rem[] = Arrays.copyOfRange(arr, 1, arr.length);
        List<List<Integer>> res = traverse(rem, i+1);
        
        List<List<Integer>> sol = new ArrayList<>();
        for(List<Integer> ele: res) {
            sol.add(ele);
            ele.add(curr);
            sol.add(ele);
        }
        
        return sol;
        
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3}));
    }
}