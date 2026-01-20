import java.util.*;

class Solution {
    int dfs(String[] maps, boolean visited[][], int i, int j){
        //반복문으로 확인
        int land;
        if(visited[i][j] == false){
            visited[i][j] = true;
            land = maps[i].charAt(j) - '0';
            // 상
            if(i > 0 && !visited[i - 1][j]){
                land += dfs(maps, visited, i - 1, j);
            }
            // 하
            if(i < maps.length - 1 && !visited[i + 1][j]){
                land += dfs(maps, visited, i + 1, j);
            }
            // 좌
            if(j > 0 && !visited[i][j - 1]){
                land += dfs(maps, visited, i, j - 1);
            }
            // 우
            if(j < maps[i].length() - 1 && !visited[i][j + 1]){
                land += dfs(maps, visited, i, j + 1);
            }
        }else{
            return 0;
        }
        return land;
    }
    public int[] solution(String[] maps) {
        boolean visited[][] = new boolean[maps.length][maps[0].length()];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int temp = 0;
        
        //바다는 이미 방문했던곳으로 표시
        for(int i = 0;i<maps.length;i++){
            for(int j = 0; j<maps[i].length();j++){
                if(maps[i].charAt(j) == 'X'){
                    visited[i][j] = true;
                }
            }
        }
        
        //for문을 통해 반복 -> 더 이상 섬이 없으면 land = 0반환
        for(int i = 0;i < maps.length;i++){
            for(int j = 0; j < maps[i].length();j++){
                temp = dfs(maps, visited, i, j);
                if(temp != 0){
                    pq.offer(temp);
                }
            }
        }
        
        if(pq.size() == 0){
            int[] none = {-1};
            return none;
        }
        
        int[] arr = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            arr[i++] = pq.poll(); // 작은 값부터 꺼냄
        }

        return arr;
    }
}