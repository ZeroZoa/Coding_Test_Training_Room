import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int flag = s / n;
        int remain = s % n;
        int[] temp = new int[n];
        int[] res = {-1};
        if(flag == 0){
            return res;
        }else{
            Arrays.fill(temp, flag);
            if(remain > 0){
                for(int i = 0; i < remain; i++){
                    temp[i]++;
                }
            }
        }
        Arrays.sort(temp);
        
        int[] answer = temp;
        return answer;
    }
}