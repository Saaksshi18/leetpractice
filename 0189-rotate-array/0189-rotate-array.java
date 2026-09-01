class Solution {
    public void rotate(int[] nums, int k) { // two pointer reversal method
        int n = nums.length;
        k = k%n;

        int temp =0;
        // reverse entire array

        for(int i =0; i<n/2; i++){
            temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }

        for(int i=0; i<k/2;i++){
            temp = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = temp;
        }

        for(int i =0; i<(n-k)/2; i++){
            temp = nums[k+i];
            nums[k+i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
    }
}