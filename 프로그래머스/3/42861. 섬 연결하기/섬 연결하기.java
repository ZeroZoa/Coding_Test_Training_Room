import java.util.*;

class Solution {
    public int[] parent;
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        } else{
            return parent[x] = find(parent[x]);
        }
    }
    
    public void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){ // 연결되어있지 않다면
            parent[y] = x;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (x, y) -> Integer.compare(x[2], y[2]));
        for(int i = 0; i < costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int dist = costs[i][2];
            
            if(find(x) != find(y)){
                union(x, y);
                answer += dist; 
            }
        }
        
        return answer;
    }
}