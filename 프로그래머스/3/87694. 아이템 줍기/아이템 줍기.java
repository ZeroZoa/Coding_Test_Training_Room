import java.util.*;

class SavePoint {
    int h, w, count;
    public SavePoint(int h, int w, int count) {
        this.h = h;
        this.w = w;
        this.count = count;
    }
}

class Solution {
    
    public boolean checkWay(int h, int w, boolean[][] map) {
        int[] dh = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dw = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            
            if (!map[h + dh[i]][w + dw[i]]) {
                return true;
            }
        }
        return false;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        boolean[][] map = new boolean[102][102];
        boolean[][] visited = new boolean[102][102];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int h = y1; h <= y2; h++) {
                for (int w = x1; w <= x2; w++) {
                    map[h][w] = true;
                }
            }
        }

        Deque<SavePoint> queue = new ArrayDeque<>();
        queue.offer(new SavePoint(characterY * 2, characterX * 2, 0));
        visited[characterY * 2][characterX * 2] = true;

        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            SavePoint temp = queue.poll();

            if (temp.h == itemY * 2 && temp.w == itemX * 2) {
                return temp.count / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nh = temp.h + dh[i];
                int nw = temp.w + dw[i];

                if (map[nh][nw] && !visited[nh][nw] && checkWay(nh, nw, map)) {
                    visited[nh][nw] = true;
                    queue.offer(new SavePoint(nh, nw, temp.count + 1));
                }
            }
        }
        return -1;
    }
}