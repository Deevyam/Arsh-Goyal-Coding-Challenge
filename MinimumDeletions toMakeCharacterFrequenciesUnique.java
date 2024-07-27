/*
1647. Minimum Deletions to Make Character Frequencies Unique
A string s is called good if there are no two different characters in s that have the same frequency.
Given a string s, return the minimum number of characters you need to delete to make s good.
The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
Example 1:
Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:
Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:
Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
Constraints:
1 <= s.length <= 105
s contains only lowercase English letters.
*/
Soln 1(HashMap & HashSet):
class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
       for(int freq:map.values()) {
            while (freq>0 && set.contains(freq)) {
                freq--;
                cnt++;
            }
            set.add(freq);
        }
    
      return cnt;
    }
}
Soln 2(Frequence Map):
class Solution {
    public int minDeletions(String s) {
        int[] map = new int[26];

        for(char c:s.toCharArray()){
            map[c-'a']++;
        }

        Set<Integer> set  = new HashSet<>();
        int cnt=0;

        for(int i=0;i<26;i++){
            int curr = map[i];
            if(curr == 0) continue;
            while(curr!= 0 && set.contains(curr)){
                cnt++;
                curr--;
            }
            set.add(curr);
        }
        return cnt;

        
    }
}

