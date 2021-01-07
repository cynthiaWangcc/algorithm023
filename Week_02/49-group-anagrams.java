import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String sortStr = String.copyValueOf(strChar);

            if(hashMap.containsKey(sortStr)) {
                hashMap.get(sortStr).add(str);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                hashMap.put(sortStr, anagrams);
            }
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(hashMap.values());
        return result;
    }
}