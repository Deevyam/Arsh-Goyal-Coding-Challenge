/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

soln :

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = -1;
        // Set the initial direction to 1 for moving left to right
        int direction = 1;

        // Create an array to store the elements in spiral order
        List<Integer> result = new ArrayList<>();

        // Traverse the matrix in a spiral order
        while (rows > 0 && cols > 0) {

            // Move horizontally in one of two directions:
            // 1. Left to right (if direction == 1)
            // 2. Right to left (if direction == -1)
            // Increment the col pointer to move horizontally
            for (int i = 0; i < cols; i++) {
                col += direction;
                result.add(matrix[row][col]);
            }
            rows--;

            // Move vertically in one of two directions:
            // 1. Top to bottom (if direction == 1)
            // 2. Bottom to top (if direction == -1)
            // Increment the row pointer to move vertically
            for (int i = 0; i < rows; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            cols--;

            // Flip the direction for the next traversal
            direction *= -1;
        }
        return result;
    }
}
