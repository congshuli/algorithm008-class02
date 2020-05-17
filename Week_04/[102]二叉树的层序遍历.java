//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root != null){
            LinkedList<TreeNode> curLevel = new LinkedList<>();
            curLevel.add(root);
            while(curLevel.size()>0){
                int size = curLevel.size();
                List<Integer> temp = new LinkedList<>();

                for(int i=0;i<size;i++){
                    TreeNode node = curLevel.remove();

                    temp.add(node.val);
                    if(node.left!=null) curLevel.add(node.left);
                    if(node.right!=null) curLevel.add(node.right);
                }
                res.add(temp);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
