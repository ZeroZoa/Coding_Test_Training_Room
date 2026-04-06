import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int[] startTime = new int[signals.length]; //시작시간
        int[] endTime = new int[signals.length]; //종료시간
        int[] repeatTime = new int[signals.length]; //주기
            
        boolean[] isY = new boolean[10000000];
        Arrays.fill(isY, true);
        
        //신호등 스펙 저장
        for(int i = 0; i < signals.length; i++){
            startTime[i] = signals[i][0] + 1;
            endTime[i] = signals[i][0] + signals[i][1];
            repeatTime[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        //3000초까지 반복
        for(int i = 1; i < 10000000; i++){
            //각 초마다 모든 신호등 순회
            for(int j = 0; j < signals.length; j++){
                int temp = i / repeatTime[j];
                
                if(i >= startTime[j] + repeatTime[j] * temp && i <= endTime[j] + repeatTime[j] * temp){
                    continue;
                }else{
                    isY[i] = false;
                }
            }
            //모든 신호등이 노란불이면
            if(isY[i] == true){
                return i;
            }
        }
        return -1;
    }
}