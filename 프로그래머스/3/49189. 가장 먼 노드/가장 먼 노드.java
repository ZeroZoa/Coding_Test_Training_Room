import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //1번 노드에서 각각의 노드까지의 거리를 저장
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        //순회하면 각 노드에서 갈수있는 노드를 추가        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edge.length; i++){
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            map.computeIfAbsent(node1, key -> new ArrayList<>()).add(node2);
            map.computeIfAbsent(node2, key -> new ArrayList<>()).add(node1);
        }
        
        //PriorityQueue 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.add(new int[] {1, 0});
        
        while(!pq.isEmpty()){
            //PriorityQueue에서 노드 꺼내기
            int[] temp = pq.poll();
            int current = temp[0]; //현재 위치
            int dist = temp[1]; //현재 위치 ~ 1로부터의 거리
            
            //1로부터의 거리 최솟값만 거를 수 있게
            if(dist > distance[current]) {
                continue;
            }
            
            //HashMap에서 한개씩 꺼내기
            for(Integer next : map.get(current)){
                int nextN = next; //현재위치에서 갈수있는 노드 꺼내기
                int nextDist = 1 + distance[current]; //현재위치에서 갈수있는 노드까지의 거리
                
                if(nextDist < distance[nextN]){
                    distance[nextN] = nextDist;
                    pq.add(new int[] {nextN, nextDist});
                }
            }
        }
        
        
        
        Arrays.sort(distance);
        int answer = 0;
        int flag = distance[distance.length-2];
        for(int i = 1; i < distance.length; i++){
            if(flag == distance[i]){
                answer++;
            }
        }
        
        return answer;
    }
}