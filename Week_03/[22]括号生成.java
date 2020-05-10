//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        _generateStr(n,0,0,"");
        return result;
    }

    public static void _generateStr(int n,int left,int right,String tempStr){
        if(left<n){
            _generateStr(n,left+1,right,tempStr+"(");
        }

        if(right<left){
            _generateStr(n,left,right+1,tempStr+")");
        }

        if(n==left&&n==right){
            result.add(tempStr);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
