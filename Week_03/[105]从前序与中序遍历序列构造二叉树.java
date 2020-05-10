//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


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
    int preIndex = 0;       //前序当前节点位置
    int[] preArr;           //前序遍历数组
    int[] inArr;            //中序遍历数组
    HashMap<Integer,Integer> inMap = new HashMap<>();       //中序数组值和index的键值对，用于确定值的序号

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preArr = preorder;
        inArr = inorder;
        //将中序遍历数组值填入map中
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        //递归
        return findTreeNode(0,inorder.length);
    }

    public TreeNode findTreeNode(int leftIndex,int rightIndex){
        //terminator 终止条件，left和right其中一个为父节点位置。相等则说明不存在子树。
        if(leftIndex==rightIndex){
            return null;
        }
        //当前节点
        TreeNode result = new TreeNode(preArr[preIndex]);
        //节点index++，由于是前序遍历，因此可以通过此方法对应上相应元素
        preIndex++;
        //获取中序遍历中的位置，大于此位置为右子树，小于此位置为左子树
        Integer inIndex = inMap.get(result.val);
        //先找出左子树，再找右子树
        result.left = findTreeNode(leftIndex,inIndex);
        result.right = findTreeNode(inIndex+1,rightIndex);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
