import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //오름차순으로 정렬되는 큐에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        
        while(K > pq.peek()){
            if(pq.size()>=2){ //큐가 안 비었으면
                int first = pq.poll();
                int second = pq.poll();
                pq.offer(first + (second*2));
                answer++;
            }else{
                return -1;
            }
        }
        
        return answer;
    }
}