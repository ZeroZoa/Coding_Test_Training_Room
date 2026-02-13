import java.util.*;

class Solution {
    static int count;

    public void dfs(int now, boolean[] visited, ArrayList<Integer>[] graph){
        visited[now] = true;
        for(int i=0; i<graph[now].size(); i++){
            int next = graph[now].get(i);
            if(visited[next]) {
                continue;
            }
            count++;
            dfs(next, visited, graph);
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer>[] graph;
        
        for(int i = 0; i < wires.length; i++){
            graph = new ArrayList[n + 1];
            
            for(int k = 1; k <= n; k++){
                graph[k] = new ArrayList<>();
            }
            int temp = 0;
            for(int j = 0; j < wires.length; j++){
                if(i == j){
                    continue;
                }else{
                    int a = wires[j][0];
                    int b = wires[j][1];
                    graph[a].add(b);
                    graph[b].add(a);
                    temp = a;
                }
            }
            
            count = 1;
            boolean visited[] = new boolean[n + 1];
            dfs(temp, visited, graph);
            
            answer = Math.min(answer, Math.abs(2*count - n));
        }
        
        return answer;
    }
}