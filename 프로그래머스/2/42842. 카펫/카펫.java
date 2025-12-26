import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        //전체 사이즈와 노란색 사이즈
        int fullSize = brown + yellow;
        int partsize = yellow;
        //전체 가로 * 세로
        int fullW = 0;
        int fullH = 0;
        int yellowW = 0;
        int yellowH = 0;
        
        for(int i = 1; i <= Math.sqrt(fullSize); i++){
            if(fullSize%i==0){
                fullH=i;
                fullW=fullSize/i;
                yellowW = fullW-2;
                yellowH = fullH-2;
                if(yellowW*yellowH==partsize){
                    break;
                }
            }
        }
        int[] answer = {fullW, fullH};
        return answer;
    }
}