/*
DFS of Graph
Difficulty: EasyAccuracy: 63.07%Submissions: 260K+Points: 2
You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Example 1:

Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

Output: 0 2 4 3 1
Explanation: 
0 is connected to 2, 3, 1.
1 is connected to 0.
2 is connected to 0 and 4.
3 is connected to 0.
4 is connected to 2.
so starting from 0, it will go to 2 then 4,
and then 3 and 1.
Thus dfs will be 0 2 4 3 1.
Example 2:

Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 

Your task:
You don't need to read input or print anything. Your task is to complete the function dfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a list containing the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
*/

soln:
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
   public void solveDFS(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        ans.add(node);
        visited[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int e=adj.get(node).get(i);
            if(!visited[e])
            solveDFS(e,visited,adj,ans);
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans=new ArrayList<>();
        boolean visited[]=new boolean[V];
        solveDFS(0,visited,adj,ans);
        return ans;
    }
}
