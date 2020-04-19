//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        //一次遍历法，遇到非零数设置到当前位置，并用零补全
        if(nums == null) {
            return;
        }

        int j = 0;
        //将非零数前移
        for(int i = 0; i<nums.length; i++) {

            if(nums[i] != 0) {
                if(i!=j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
