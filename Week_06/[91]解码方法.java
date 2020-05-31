//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        dp[len-1] = s.charAt(len-1)=='0'?0:1;
        //
        int num = 0;
        for(int i = len-2;i>=0;i--){
            if(s.charAt(i)=='0'){
                continue;
            }

            if(checkDouble(s.charAt(i),s.charAt(i+1))){
                dp[i] = dp[i+1]+dp[i+2];
            }else{
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    public boolean checkDouble(char f,char s){
        if(f=='1'){
            return true;
        } else if(f=='2'){
            return s<='6';
        }else{
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
