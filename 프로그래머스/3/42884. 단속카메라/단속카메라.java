import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int index = 0;
        int currentPoint = routes[0][1];
        int endPoint = routes[routes.length - 1][1];
        
        while(currentPoint <= endPoint){
            answer++;
            for(int i = index; i < routes.length; i++){
                //다음 인덱스 찾기
                if(routes[i][0] > currentPoint){
                    index = i;
                    currentPoint = routes[i][1];
                    break;
                }
                
                if(i==routes.length-1){
                    return answer;
                }
            }
        }
        return answer;
    }
}