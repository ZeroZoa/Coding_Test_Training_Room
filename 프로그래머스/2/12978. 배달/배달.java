import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        //마을번호, 길 쌍으로 저장
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int i = 0; i < road.length; i++){
            //road순회하며 도시1, 도시2, 도시1-도시2의 거리를 저장
            int n1 = road[i][0];
            int n2 = road[i][1];
            int dist = road[i][2];
            
            map.computeIfAbsent(n1, k -> new ArrayList<>()).add(new int[] {n2, dist});
            map.computeIfAbsent(n2, k -> new ArrayList<>()).add(new int[] {n1, dist});
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.add(new int[] {1, 0});
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int n = current[0];
            int dist = current[1];
            
            if(dist > distance[n]) {
                continue;
            }
            
            for(int[] next : map.get(n)){
                int nextN = next[0];
                int nextDist = distance[n] + next[1];
                
                if(nextDist < distance[nextN]){
                    distance[nextN] = nextDist;
                    pq.add(new int[] {nextN, nextDist});
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i < distance.length;i++){
            if(distance[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}