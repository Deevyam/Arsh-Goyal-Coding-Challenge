/*
378. Kth Smallest Element in a Sorted Matrix
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).
Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
*/
Soln 1 :PriorityQueue
class Solution {
    public int kthSmallest(int[][] mat, int k) {
       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pq.size()>k)
                {
                    pq.poll();
                }
                pq.add(mat[i][j]);
            }
        }
        if(pq.size()>k)
                {
                    pq.poll();
                }
        return pq.peek();
    }
}
Soln 2: Binary Search
class Solution {
    int binary(int[][] matrix,int mid){
        int cnt=0,n=matrix.length,i=n-1,j=0;
        while(i>=0 && j<n){
            if(matrix[i][j]>mid) i--;
            else{
                cnt+=(i+1);
                j++;
            }
        }
        return cnt;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, i = matrix[0][0], j = matrix[n-1][n-1];
        while(i < j){
            int mid = i + (j-i)/2;
            int posi = binary(matrix, mid);
            if(posi < k) i = mid+1;
            else j = mid;
        }
        return i;
    }
}
