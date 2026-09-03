class Solution {
    public int missingNumber(int[] nums) {
        int exp;
        int n = nums.length;
        exp = (n*(n+1))/2;

        int sum=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        int dif;

        dif= exp-sum;
        return dif;
    }
}