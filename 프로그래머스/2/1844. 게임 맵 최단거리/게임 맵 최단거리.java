import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Deque<int[]> queue = new ArrayDeque<>();
        // 시작점: (0,0)에서 거리 1
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int dist = temp[2];

            // 도착점에 도달하면 최단거리 반환
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            // 상
            if (x > 0 && maps[x - 1][y] == 1 && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                queue.offer(new int[]{x - 1, y, dist + 1});
            }
            // 하
            if (x < n - 1 && maps[x + 1][y] == 1 && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                queue.offer(new int[]{x + 1, y, dist + 1});
            }
            // 좌
            if (y > 0 && maps[x][y - 1] == 1 && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                queue.offer(new int[]{x, y - 1, dist + 1});
            }
            // 우
            if (y < m - 1 && maps[x][y + 1] == 1 && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                queue.offer(new int[]{x, y + 1, dist + 1});
            }
        }

        // 도착할 수 없는 경우
        return -1;
    }
}