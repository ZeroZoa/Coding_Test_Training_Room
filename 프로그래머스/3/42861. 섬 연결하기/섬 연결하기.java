import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 노드별 연결 및 거리 init
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < costs.length; i++){
            int node1 = costs[i][0];
            int node2 = costs[i][1]; 
            int dist = costs[i][2];

            map.computeIfAbsent(node1, key -> new ArrayList<>()).add(new int[] {node2, dist});
            map.computeIfAbsent(node2, key -> new ArrayList<>()).add(new int[] {node1, dist});
        }
        
        while(){
            
        }
        
        return answer;
    }
}