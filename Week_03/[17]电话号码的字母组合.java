//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)) return new LinkedList<String>();

        if(digits.length()==1){
            return getNumToStr(digits);
        }

        int len = digits.length();
        int mid = len/2;
        List<String> subLeft = letterCombinations(digits.substring(0,mid));
        List<String> subRight = letterCombinations(digits.substring(mid,len));

        return mergList(subLeft,subRight);
    }

    //合并两个子集
    public List<String> mergList(List<String> subLeft,List<String> subRight){
        List<String> result = new LinkedList<>();
        for(int l = 0;l<subLeft.size();l++){
            for(int r = 0;r<subRight.size();r++){
                result.add(subLeft.get(l)+subRight.get(r));
            }
        }
        return result;
    }

    public LinkedList<String> getNumToStr(String num){
        switch(num){
            case "2": return new LinkedList<String>(){{add("a");add("b");add("c");}};
            case "3": return new LinkedList<String>(){{add("d");add("e");add("f");}};
            case "4": return new LinkedList<String>(){{add("g");add("h");add("i");}};
            case "5": return new LinkedList<String>(){{add("j");add("k");add("l");}};
            case "6": return new LinkedList<String>(){{add("m");add("n");add("o");}};
            case "7": return new LinkedList<String>(){{add("p");add("q");add("r");add("s");}};
            case "8": return new LinkedList<String>(){{add("t");add("u");add("v");}};
            case "9": return new LinkedList<String>(){{add("w");add("x");add("y");add("z");}};
        }
        return new LinkedList<String>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
