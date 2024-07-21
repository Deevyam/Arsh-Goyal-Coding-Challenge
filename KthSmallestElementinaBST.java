/*
230. Kth Smallest Element in a BST
Solved
Medium
Topics
Companies
Hint
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
Follow up: if the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
*/

soln 1:(PriorityQueue / Heaps)
class Solution {
     PriorityQueue<Integer> pq=new PriorityQueue<>();
     void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        pq.offer(root.val);
        inorder(root.right);
     }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        int x=0;
        while(k!=0){
            x=pq.poll();
            k--;
        }
        return x;
    }
}
Soln 2:
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int n = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            n++;
            if (n == k) return current.val;
            current = current.right;
        }

        return -1;
    }
}

