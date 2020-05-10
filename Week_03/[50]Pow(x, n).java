//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        //必须转换成long，因为当n=-2147483648时，转换成正数会有丢失
        //最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
        //最大值：Integer.MAX_VALUE= 2147483647  （2的31次方-1）
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        return fastPow(x,N);
    }

    public double fastPow(double x, long N){
        if(N==0) return 1.0;

        double half = fastPow(x,N/2);
        return (N&1)==1?half*half*x:half*half;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
