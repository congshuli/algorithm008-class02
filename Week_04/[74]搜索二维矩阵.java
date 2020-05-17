//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int gl = 0,gr = matrix.length-1,gmid = 0;
        while(gl<=gr){
            gmid = gl + (gr - gl)/2;
            int tempRes = getTargetNum(matrix[gmid],target);
            switch(tempRes){
                case 0:return true;
                case -1:gr = gmid - 1;break;
                case 1:gl = gmid + 1;break;
                case -2:return false;
                default:break;
            }
        }
        return false;
    }
    //返回0：已找到
    //返回-1：小于最小值
    //返回1：大于最大值
    //返回-2：未找到
    public int getTargetNum(int[] nums,int target){
        if(nums.length==0) return -2;

        int min = nums[0],max = nums[nums.length - 1];
        if(target<min) return -1;
        if(target>max) return 1;

        int l = 0,r = nums.length - 1,mid = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid]==target) return 0;

            if(nums[mid]>target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
