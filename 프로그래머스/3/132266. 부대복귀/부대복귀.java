import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination] = 0;
        
        //각 지역 연결저장
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < roads.length; i++){
            int node1 = roads[i][0];
            int node2 = roads[i][1];
            map.computeIfAbsent(node1, key -> new ArrayList<>()).add(node2);
            map.computeIfAbsent(node2, key -> new ArrayList<>()).add(node1);
        }
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {destination, 0});
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int current = temp[0];
            int dist = temp[1];
            
            if(dist > distance[current]){
                continue;
            }
            
            for(Integer next : map.get(current)){
                int nextN = next;
                int nextDist = distance[current] + 1;
                
                if(nextDist < distance[nextN]){
                    distance[nextN] = nextDist;
                    queue.add(new int[] {nextN, nextDist});
                }
            }
        }
        
        for(int i = 0; i < distance.length; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = distance[sources[i]];
        }
        return answer;
    }
}