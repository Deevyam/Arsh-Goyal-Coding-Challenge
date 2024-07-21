/*
Replace O's with X's
Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.
A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.
Example 1:
Input: 
n = 5, m = 4
mat = {{'X', 'X', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix. 
Example 2:
Input: 
n = 5, m = 4
mat = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix.
Your Task:
You do not need to read input or print anything. 
Your task is to complete the function fill() which takes N, M and mat as input parameters ad returns a 2D array representing the resultant matrix.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
*/

Soln :
class Solution{
    static void dfs(int i, int j, char[][] arr) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 'O') {
            return;
        }
        arr[i][j] = '-'; // Temporary marker to avoid revisiting
        dfs(i + 1, j, arr);
        dfs(i - 1, j, arr);
        dfs(i, j + 1, arr);
        dfs(i, j - 1, arr);
    }

    static char[][] fill(int n, int m, char[][] arr) {
        // First pass: mark all 'O's connected to borders with '-'
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 'O') dfs(i, 0, arr);
            if (arr[i][m - 1] == 'O') dfs(i, m - 1, arr);
        }
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 'O') dfs(0, j, arr);
            if (arr[n - 1][j] == 'O') dfs(n - 1, j, arr);
        }

        // Second pass: flip all remaining 'O's to 'X', and '-' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'O') {
                    arr[i][j] = 'X';
                } else if (arr[i][j] == '-') {
                    arr[i][j] = 'O';
                }
            }
        }
        return arr;
    }
}
