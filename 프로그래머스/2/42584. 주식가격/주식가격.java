import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> answer = new ArrayDeque<>();
        
        for(int i=1;i<=prices.length;i++){
            int count = 1;
            int sp = prices[i-1];
            if(i==prices.length){
                answer.offer(0);
            }else{
                for(int j=i;j<prices.length;j++){
                    if(sp <= prices[j] && (j+1)!=prices.length){//
                        count++;
                    }else{
                        answer.offer(count);
                        break;
                    }
                }
            }
        }
        return answer.stream()
             .mapToInt(Integer::intValue)
             .toArray();
    }
}