import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int chance = k;
        
        //StringBuilder에 number 추가
        StringBuilder sb = new StringBuilder();
        sb.append(number);
    
        
        //앞자리수 제거
        int i = 0;
        while (i < sb.length() - 1) {
            if (chance <= 0) break; 

            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                chance--;
                i = 0; // for문의 i = -1과 동일 (삭제했으므로 처음부터 다시 검사)
            } else {
                i++; // 삭제하지 않았을 때만 다음 인덱스로 이동
            }
        }

        sb.reverse();

        // 두 번째 루프
        i = 0; // i 초기화
        while (i < sb.length() - 1) {
            if (chance <= 0) break;

            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                chance--;
                i = 0; // 처음부터 다시 검사
            } else {
                i++;
            }
        }

        sb.reverse();
        
        String answer = sb.toString();
        
        return answer;
        
    }
}
