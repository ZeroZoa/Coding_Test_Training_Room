class Solution {
    static int answer = 0;
    
    public void dfs(int n, int now, int[][] computers, boolean[] visited){
        visited[now] = true;
            
        for(int i = 0; i < n; i++){
            if(computers[now][i] == 1 && visited[i] == false){
                dfs(n, i, computers, visited);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        //방문기록
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(n, i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
}