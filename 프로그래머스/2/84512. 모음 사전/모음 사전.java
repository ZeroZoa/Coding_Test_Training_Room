import java.util.*;

class Solution {
    public int checkLetter(char letter){
        if(letter=='A'){
            return 0;
        }else if(letter=='E'){
            return 1;
        }else if(letter=='I'){
            return 2;
        }else if(letter=='O'){
            return 3;
        }else{
            return 4;
        }
    }
    public int solution(String word) {
        int answer = 0;
        int count = 0;
        for(int i = 0; i < word.length();i++){
            count = 0; //count 초기화
            for(int j = 4-i; j >= 0; j--){
                count = count + (int)Math.pow(5, j);
            }
            answer = answer + 1 + (count*checkLetter(word.charAt(i)));
        }
        return answer;
    }
}

            // count = 0;
            // for(int j=4-i;j>=5-word.length();j--){
            //     count += Math.pow(5, j);
            // }
            // answer = answer + (checkLetter(word.charAt(i)) * count)+1;