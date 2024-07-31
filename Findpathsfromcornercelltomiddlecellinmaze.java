/*
Find paths from corner cell to middle cell in maze
Given a square maze containing positive numbers, find all paths from a corner cell (any of the extreme four corners) to the middle cell.
We can move exactly n steps from a cell in 4 directions i.e. North, East, West and South where n is value of the cell, 
We can move to mat[i+n][j], mat[i-n][j], mat[i][j+n], and mat[i][j-n] from a cell mat[i][j] where n is value of mat[i][j].

Example
Input:  9 x 9 maze
[ 3, 5, 4, 4, 7, 3, 4, 6, 3 ]
[ 6, 7, 5, 6, 6, 2, 6, 6, 2 ]
[ 3, 3, 4, 3, 2, 5, 4, 7, 2 ]
[ 6, 5, 5, 1, 2, 3, 6, 5, 6 ]
[ 3, 3, 4, 3, 0, 1, 4, 3, 4 ]
[ 3, 5, 4, 3, 2, 2, 3, 3, 5 ]
[ 3, 5, 4, 3, 2, 6, 4, 4, 3 ]
[ 3, 5, 1, 3, 7, 5, 3, 6, 4 ]
[ 6, 2, 4, 3, 4, 5, 4, 5, 1 ]

Output:
(0, 0) -> (0, 3) -> (0, 7) -> 
(6, 7) -> (6, 3) -> (3, 3) -> 
(3, 4) -> (5, 4) -> (5, 2) -> 
(1, 2) -> (1, 7) -> (7, 7) ->
(7, 1) -> (2, 1) -> (2, 4) -> 
(4, 4) -> MID
*/

Soln:
import java.util.ArrayList;
import java.util.List;

public class MazeSolver {
    private static final int SIZE = 9;
    private static final int MID = SIZE / 2;

    public static void main(String[] args) {
        int[][] maze = {
            {3, 5, 4, 4, 7, 3, 4, 6, 3},
            {6, 7, 5, 6, 6, 2, 6, 6, 2},
            {3, 3, 4, 3, 2, 5, 4, 7, 2},
            {6, 5, 5, 1, 2, 3, 6, 5, 6},
            {3, 3, 4, 3, 0, 1, 4, 3, 4},
            {3, 5, 4, 3, 2, 2, 3, 3, 5},
            {3, 5, 4, 3, 2, 6, 4, 4, 3},
            {3, 5, 1, 3, 7, 5, 3, 6, 4},
            {6, 2, 4, 3, 4, 5, 4, 5, 1}
        };

        List<List<int[]>> paths = new ArrayList<>();
        int[][] corners = {{0, 0}, {0, 8}, {8, 0}, {8, 8}};
        
        for (int[] corner : corners) {
            boolean[][] visited = new boolean[SIZE][SIZE];
            List<int[]> path = new ArrayList<>();
            dfs(maze, corner[0], corner[1], visited, path, paths);
        }

        for (List<int[]> path : paths) {
            for (int[] cell : path) {
                System.out.print("(" + cell[0] + ", " + cell[1] + ") -> ");
            }
            System.out.println("MID");
        }
    }

    private static void dfs(int[][] maze, int x, int y, boolean[][] visited, List<int[]> path, List<List<int[]>> paths) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE || visited[x][y]) {
            return;
        }

        path.add(new int[]{x, y});
        visited[x][y] = true;

        if (x == MID && y == MID) {
            paths.add(new ArrayList<>(path));
        } else {
            int steps = maze[x][y];

            // Move North
            if (x - steps >= 0) {
                dfs(maze, x - steps, y, visited, path, paths);
            }
            // Move East
            if (y + steps < SIZE) {
                dfs(maze, x, y + steps, visited, path, paths);
            }
            // Move South
            if (x + steps < SIZE) {
                dfs(maze, x + steps, y, visited, path, paths);
            }
            // Move West
            if (y - steps >= 0) {
                dfs(maze, x, y - steps, visited, path, paths);
            }
        }

        path.remove(path.size() - 1);
        visited[x][y] = false;
    }
}
