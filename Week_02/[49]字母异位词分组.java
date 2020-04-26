//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //将数组中的元素 按字符排序后进行比较
        if(strs.length==0) return new ArrayList<>();

        Map<String,List<String>> ans = new HashMap<>();
        for(String str:strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String strSort = String.valueOf(temp);

            if(!ans.containsKey(strSort)) {
                ans.put(strSort,new ArrayList<String>());
            }
            ans.get(strSort).add(str);
        }

        return new ArrayList<>(ans.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
