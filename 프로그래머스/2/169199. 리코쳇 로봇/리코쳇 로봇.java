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
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Deque<SavePoint> queue = new ArrayDeque<>();
        
        //시작점, 끝점 확인
        int spx = 0;
        int spy = 0;
        int epx = 0;
        int epy = 0;
        
        for(int i = 0;i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'R'){
                    spx=i;
                    spy=j;
                }else if(board[i].charAt(j) == 'G'){
                    epx=i;
                    epy=j;
                }
            }
        }
        
        queue.offer(new SavePoint(spx, spy, 0));
        
        while(!queue.isEmpty()){
            SavePoint temp = queue.poll();
            if(temp.x == epx && temp.y == epy){
                return temp.count;
            }else if(board[temp.x].charAt(temp.y) =='D'){
                continue;
            }else{
                //상
                int i = 0;
                while(temp.x - i > 0 && board[temp.x - i - 1].charAt(temp.y) !='D'){
                    i++;
                }
                if(visited[temp.x - i][temp.y] == false){
                    visited[temp.x - i][temp.y] = true;
                    queue.offer(new SavePoint(temp.x - i, temp.y, temp.count + 1));
                }
                //하
                i = 0;
                while(temp.x + i < n - 1 && board[temp.x + i + 1].charAt(temp.y) !='D'){
                    i++;
                }
                if(visited[temp.x + i][temp.y] == false){
                    visited[temp.x + i][temp.y] = true;
                    queue.offer(new SavePoint(temp.x + i, temp.y, temp.count + 1));
                }
                //좌
                i = 0;
                while(temp.y - i > 0 && board[temp.x].charAt(temp.y - i - 1) !='D'){
                    i++;
                }
                if(visited[temp.x][temp.y - i] == false){
                    visited[temp.x][temp.y - i] = true;
                    queue.offer(new SavePoint(temp.x, temp.y - i, temp.count + 1));
                }
                //우
                i = 0;
                while(temp.y + i < m - 1 && board[temp.x].charAt(temp.y + i + 1) !='D'){
                    i++;
                }
                if(visited[temp.x][temp.y + i] == false){
                    visited[temp.x][temp.y + i] = true;
                    queue.offer(new SavePoint(temp.x, temp.y + i, temp.count + 1));
                }
            }
        }
        return -1;
    }
}