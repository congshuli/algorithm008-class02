//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2) return true;

        //二分法
        long l=2,r = num/2,mid=0,square=0;
        while(l<=r){
            mid = (l+r)/2;
            square = mid*mid;
            if(square == num){
                return true;
            }
            if(square > num){
                r = mid-1;
            }else{
                l = mid +1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
