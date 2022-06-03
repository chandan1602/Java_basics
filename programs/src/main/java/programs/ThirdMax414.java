package programs;

class ThirdMax414 {
    public static void main(String[] args) {
        int arr[] = {2,2,3,1};
        System.out.println(thirdMax(arr));
    }
    public static int thirdMax(int[] nums) {
        int max=-2_147_483_648, max1=-2_147_483_648, max2=-2_147_483_648;
        for(int ele: nums) {
            if(ele>=max) {
                max2=max1;
                max1=max;
                max=ele;
            } else if(ele>=max1) {
                max2=max1;
                max1=ele;
            } else if(ele>max2) {
                max2=ele;
            }
        }
        if(max2==max || max2==max1 || nums.length<3) return max;
        return max2;
    }
}