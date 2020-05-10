//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int k;
    public List<List<Integer>> subsets(int[] nums) {
        //回溯
        List<List<Integer>> result = new ArrayList<>();
        //在递归过程中会把所有中间结果添加到结果集
        //添加顺序 [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
        backtrack(0,nums,new ArrayList<Integer>(),result);
        return result;
    }

    public void backtrack(int first,int[] nums,List<Integer> subset,List<List<Integer>> result){
        //添加时一定要new一个列表，因为原对象会在上层移除元素。
        result.add(new ArrayList<>(subset));
        for(int i=first;i<nums.length;i++){
            subset.add(nums[i]);
            backtrack(i+1,nums,subset,result);
            subset.remove(subset.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
