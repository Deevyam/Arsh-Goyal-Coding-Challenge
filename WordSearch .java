/*
79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/
Soln : DFS

  class Solution {
    boolean dfs(int i,int j,char[][] grid,String s,int val){
        if(val==s.length()) return true;
        if(i<0 || j<0 ||i>=grid.length||j>=grid[0].length || grid[i][j] != s.charAt(val)) 
        return false;
        char temp= grid[i][j];
        grid[i][j]=' ';
        boolean found = dfs(i+1,j,grid,s,val+1)||
        dfs(i-1,j,grid,s,val+1)||
        dfs(i,j+1,grid,s,val+1)||
        dfs(i,j-1,grid,s,val+1);
        grid[i][j]=temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
}
