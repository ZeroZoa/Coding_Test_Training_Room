import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //오름차순 정렬
        Arrays.sort(people);
        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
        
        int temp = list.size() - 1;
        int endIndex = list.size() - 1;
        while(temp>0){
            if(list.get(temp)>limit-list.get(endIndex)){
                temp--;
            }else{
                break;
            }
        }
        
        
        int startIndex = temp;
        
        
        while(!list.isEmpty() && startIndex < endIndex){//list가 비거나 시작점과 끝점이 같아지면 종료
            if(list.get(startIndex)+list.get(endIndex)<=limit){
                list.remove(startIndex);
                list.remove(endIndex);
                endIndex = endIndex - 2;
                answer++;
            }else{
                if(startIndex>0){
                    startIndex--;
                }else{
                    endIndex--;
                }
            }
        }
        answer = answer + list.size();
        return answer;
    }
}