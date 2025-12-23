import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int point = 0;
        Arrays.sort(citations);
        point = citations[citations.length-1];
        
        while(true){
            int count = 0;
            for(int i=0;i<citations.length; i++){//길이 만큼 반복
                if(citations[i]<point){//h번 이하로 인용된 논문이 나오면 count
                    count++;
                }else{//h번 이상 인용된 논문이 나오면 break
                    break;
                }
            }
            if((citations.length-count)>=point&&count<=point){
                answer = point;
                break;
            }else{
                if(point==0){
                    return 0;
                }else{
                    point--;
                }
            }
        }
        return answer;
    }
}