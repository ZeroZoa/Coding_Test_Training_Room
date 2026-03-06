import java.util.*;


class Solution {
    public int countAlphabet(char c){
        int count = 0;
        if(c - 64 <= 13){
            count += c - 'A';
        }else{
            count += 26 - c + 'A';
        }
        return count;
    }
    
    public int solution(String name) {
        int answer = 0;
        int leftRight = name.length() - 1;
        //알파벳 보정횟수 
        for(int i = 0; i < name.length(); i++){
            answer += countAlphabet(name.charAt(i));
            
            int next = i + 1;
        
            //커서 이동횟수
            while(next < name.length() && name.charAt(next)=='A'){
                next++;
            }
            leftRight = Math.min(leftRight, Math.min((i+name.length()-next+i),(i+name.length()-next+name.length()-next)));
        }
        
        
        return answer +leftRight;
    }
}