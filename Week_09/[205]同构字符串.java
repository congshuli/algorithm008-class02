//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.equals(t)){return true;}

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map2.get(t.charAt(i)) == null){
                map2.put(t.charAt(i),s.charAt(i));
            }else if(!map2.get(t.charAt(i)).equals(s.charAt(i))){
                return false;
            }

            if(map1.get(s.charAt(i)) == null){
                map1.put(s.charAt(i),t.charAt(i));
            }else if(!map1.get(s.charAt(i)).equals(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
