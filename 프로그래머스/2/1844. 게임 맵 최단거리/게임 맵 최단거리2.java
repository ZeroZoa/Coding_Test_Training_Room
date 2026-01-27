import java.util.*;
class SavePoint{
    public int x;
    public int y;
    public int count;
    
    public SavePoint(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Deque<SavePoint> queue = new ArrayDeque<>();
        
        queue.offer(new SavePoint(0, 0, 1));
        
        while(!queue.isEmpty()){
            SavePoint temp = queue.poll();
            
            if(temp.x == n - 1 && temp.y == m - 1){
                return temp.count;
            }else{
                if(temp.x > 0 && maps[temp.x - 1][temp.y] == 1 && !visited[temp.x - 1][temp.y]){
                    visited[temp.x - 1][temp.y] = true;
                    queue.offer(new SavePoint(temp.x - 1, temp.y, temp.count + 1));
                }
                //하
                if(temp.x < n - 1 && maps[temp.x + 1][temp.y] == 1 && !visited[temp.x + 1][temp.y]){
                    visited[temp.x + 1][temp.y] = true;
                    queue.offer(new SavePoint(temp.x + 1, temp.y, temp.count + 1));
                }
                //좌
                if(temp.y > 0 && maps[temp.x][temp.y - 1] == 1 && !visited[temp.x][temp.y - 1]){
                    visited[temp.x][temp.y - 1] = true;
                    queue.offer(new SavePoint(temp.x, temp.y - 1, temp.count + 1));
                }
                //우
                if(temp.y < m - 1 && maps[temp.x][temp.y + 1] == 1 && !visited[temp.x][temp.y + 1]){
                    visited[temp.x][temp.y + 1] = true;
                    queue.offer(new SavePoint(temp.x, temp.y + 1, temp.count + 1));
                } 
            }
        }
        return -1;
    }
}
