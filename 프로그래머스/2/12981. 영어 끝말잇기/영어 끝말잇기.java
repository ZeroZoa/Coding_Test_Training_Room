import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        //단어 확인용
        Set<String> set = new HashSet<>();
        
        //첫단어, 첫단어 맨끝 글자 init
        String tempW = words[0];
        char tempL = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);
        
        //반복하며 확인 시작
        for(int i = 1; i < words.length; i++){
            if(words[i].charAt(0) == tempL){ //끝말잇기가 성립하면
                if(set.contains(words[i])){ //포함하면 종료
                    if((i + 1) % n == 0){
                        answer[0] = n;
                    }else{
                        answer[0] = (i + 1) % n;
                    }
                    
                    answer[1] = i / n + 1;
                    return answer;
                }else{ //포함하지 않으면 추가
                    tempL = words[i].charAt(words[i].length() - 1);
                    set.add(words[i]);
                }
            }else{ //끝말잇기가 성립하지않으면
                if((i + 1) % n == 0){
                        answer[0] = n;
                    }else{
                        answer[0] = (i + 1) % n;
                    }
                answer[1] = i / n + 1;
                return answer;
            }
        }
        return answer;
        
    }
}