//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(1,n,k,new LinkedList<Integer>());
        return res;
    }

    public void combineHelper(int cur,int n,int k,LinkedList<Integer> temp){
        //终止条件
        if(k==0){
            res.add(temp);
            return;
        }
        //迭代、回溯
        while((cur+k-1)<=n){
            temp.add(cur++);
            combineHelper(cur,n,k-1,(LinkedList<Integer>)temp.clone());
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
