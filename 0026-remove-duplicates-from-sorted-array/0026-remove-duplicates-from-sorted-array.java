class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0; // index of last unique element
        for(int i=0; i<nums.length; i++){
            if(nums[j] != nums[i]){
                j++; //to manipulate the next index of the last unique elem
                nums[j] = nums[i]; 
            }
        }
        return j+1;
    }
}