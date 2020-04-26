//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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
    public List<Integer> inorderTraversal(TreeNode root) {
        //颜色标记法，将根节点（初次入栈节点）标记为白节点（isGray = false），出栈遍历时，将出栈节点标记为灰节点（isGray = true）,按照此规则，将右节点、出栈节点、左节点依次入栈(因为要返回中序遍历结果（左节点、根节点、右节点），所以倒序入栈)，当遇到灰节点时，输出节点数值。
        if(root==null){return new ArrayList<Integer>();}
        List<Integer> result = new ArrayList();
        Stack<ColorNode> nodes = new Stack<>();
        //初始节点不为灰
        ColorNode cn = new ColorNode(root,false);
        nodes.push(cn);

        while(!nodes.isEmpty()){
            cn = nodes.pop();
            if(cn.isGray) {
                result.add(cn.val);
            }else {
                cn.isGray = true;
                if(cn.right!=null)
                    nodes.push(new ColorNode(cn.right,false));
                nodes.push(cn);
                if(cn.left!=null)
                    nodes.push(new ColorNode(cn.left,false));
            }
        }

        return result;
    }
    //颜色标记法节点，是否为灰色节点
    public class ColorNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        boolean isGray;

        public ColorNode(TreeNode node,boolean isGray){
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
            this.isGray = isGray;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
