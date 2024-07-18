/*
20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
Soln:
class Solution {
    public boolean isValid(String st) {
        Stack<Character> stack = new Stack<>();
        char[] s = st.toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                stack.push(s[i]);
            } else {
                if (stack.isEmpty()) return false;

                char c = stack.pop();
                if (c == '(' && s[i] != ')' ||
                    c == '{' && s[i] != '}' ||
                    c == '[' && s[i] != ']') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
