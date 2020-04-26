//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){return new LinkedList<>();}
        //使用队列实现 广度优先搜索
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> deq = new ArrayDeque<Node>();
        deq.add(root);
        while(!deq.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int levelSize = deq.size();

            for(int i = 0;i<levelSize;i++){
                Node node = deq.removeFirst();
                level.add(node.val);
                deq.addAll(node.children);
            }
            result.add(level);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
