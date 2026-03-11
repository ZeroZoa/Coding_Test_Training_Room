import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: works){
            pq.offer(i);
        }
        
        while(n > 0){
            int max = pq.poll();
            if(max > 0){
                max--;
                n--;
                pq.offer(max);
            }else{
                break;
            }
        }
        for (int i : pq) {
            answer += (long) i * i;
        }

        return answer;
    }
}