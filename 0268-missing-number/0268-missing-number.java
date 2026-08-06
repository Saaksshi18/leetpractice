class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum=0;
        int s =0;
        for(int i =0; i<=n; i++){
            sum += i;
        }

        for(int j=0; j<n; j++){
            s += nums[j];
        }

        int res;
        res = sum-s;

        return res;
    }
}