//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()<=1) return true;
        return validateStr(s,1);
    }
    public boolean validateStr(String s,int removeNum){
        int i = 0,j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;j--;
            }else{
                return removeNum>0?validateStr(s.substring(i,j),removeNum-1)||validateStr(s.substring(i+1,j+1),removeNum-1):false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
