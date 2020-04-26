//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;

        int numI2 = 0,numI3 = 0,numI5 = 0,curI = 1;
        while(curI<n) {
            nums[curI] = Math.min(nums[numI2]*2,Math.min(nums[numI3]*3,nums[numI5]*5));
            if(nums[curI]==nums[numI2]*2) numI2++;
            if(nums[curI]==nums[numI3]*3) numI3++;
            if(nums[curI]==nums[numI5]*5) numI5++;
            curI++;
        }
        return nums[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
