import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();

        dist[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) {
                    continue;
                }

                int cost = grid.get(newRow).get(newCol);
                int newDist = dist[row][col] + cost;

                if (newDist < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newDist;

                    if (cost == 0) {
                        deque.offerFirst(new int[]{newRow, newCol});
                    } else {
                        deque.offerLast(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}