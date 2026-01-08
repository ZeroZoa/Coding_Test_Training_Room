import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] people, int limit) {
        //오름차순 정렬
        Arrays.sort(people);
        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
        
        int answer = 0;
        int startIndex = 0;
        int endIndex = list.size() - 1;
        
        while(startIndex <= endIndex){//list가 비거나 시작점과 끝점이 같아지면 종료
            if(list.get(startIndex)+list.get(endIndex)<=limit){
                startIndex++;
                endIndex--;
                answer++;
            }else{
                endIndex--;
                answer++;
            }
        }
        return answer;
    }
}