//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int m = matrix.length;
        if(m!=0){
            int n = matrix[0].length;
            //dp[i][j] 表示 以i行j列为右下角的正方形的边长
            //递推方程,当dp[i][j]为1，有dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1;否则为0;
            int[][] dp = new int[m][n];
            for(int i = 0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if(i==0||j==0){
                        dp[i][j] = matrix[i][j] == '1'?1:0;
                    }else {
                        dp[i][j] = matrix[i][j] == '1'?Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1:0;
                    }
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
            }
        }

        return maxLen*maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
