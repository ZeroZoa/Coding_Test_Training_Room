import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        //기지국 정렬
        Arrays.sort(stations);
        int end = 1;
        int l = 1; //기지국의 왼쪽 커버
        int r = 1; //기지국의 오른쪽 커버
        int c = 2 * w + 1; //기지국의 커버
        int answer = 0;
        
        for(int i = 0; i < stations.length; i++){
            l = stations[i] - w;
            r = stations[i] + w;
            if(end < l){
                if((l - end) % c == 0){
                    answer += (l - end) / c;
                }else{
                    answer += (l - end) / c + 1;
                }
            }
            end = r + 1;
        }
        if (end <= n) {
            int len = n - end + 1;
            answer += (len + c - 1) / c;
        }
        return answer;
    }
}