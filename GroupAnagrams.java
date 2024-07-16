/*
49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/
soln:
class Solution {
    String srt(String str){
        char a[]=str.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            String ss=srt(s);
        if(!map.containsKey(ss)){
            map.put(ss,new ArrayList<>());
        }
        map.get(ss).add(s);
    }
       return new ArrayList<>(map.values());
   
    }
}
