//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] cols; //被占据的列
    int[] dales;//被占据的左上-右下的斜线
    int[] hills;//被占据的右上-左下的斜线
    int n;      //皇后数量
    List<List<String>> res = new ArrayList<>(); //解决方案合集
    int[] queens;      //一种解决方案

    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        dales = new int[2*n];
        hills = new int[2*n];
        this.n = n;
        queens = new int[n];
        backTrack(0);
        return res;
    }

    //是否能被攻击到
    public boolean isUnderAttack(int row,int col){
        return cols[col]==1||dales[row-col+n]==1||hills[row+col]==1;
    }

    //放置一个皇后
    public void placeQueen(int row,int col){
        queens[row]=col;
        cols[col]=1;
        dales[row-col+n]=1;
        hills[row+col] = 1;
    }

    //移除一个皇后
    public void removeQueen(int row,int col){
        queens[row]=0;
        cols[col]=0;
        dales[row-col+n]=0;
        hills[row+col] = 0;
    }

    //添加一种解决方案
    public void addSolution(){
        List<String> tempRes = new ArrayList<>();

        for(int i =0;i<queens.length;i++){
            int j=0;
            StringBuilder sb = new StringBuilder();
            while(j<n){
                sb.append(j++==queens[i]?"Q":".");
            }
            tempRes.add(sb.toString());
        }
        res.add(tempRes);
    }

    //回溯
    public void backTrack(int row){
        for(int i=0;i<n;i++){
            //若不在任意攻击范围内，则在此放置一个皇后
            if(!isUnderAttack(row,i)){
                placeQueen(row,i);
                //若已经是最后一行，则添加到解决方案中，否则下探到下一行
                if(row == n - 1) {
                    addSolution();
                }else{
                    backTrack(row+1);
                }
                //回溯，寻找其他解决方案
                removeQueen(row,i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
