import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int chance = k;
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        
        for(int i = 0; i < number.length(); i++){
            while(!stack1.isEmpty()&&chance>0&&stack1.peek()<number.charAt(i)){
                stack1.pop();
                chance--;
            }
            stack1.push(number.charAt(i));
        }
        
        StringBuilder sb1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb1.append(stack1.pop());
        }
        
        for(int i = 0; i < sb1.length(); i++){
            while(!stack2.isEmpty()&&chance>0&&stack2.peek()<sb1.charAt(i)){
                stack2.pop();
                chance--;
            }
            stack2.push(sb1.charAt(i));
        }
        
        StringBuilder sb2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb2.append(stack2.pop());
        }
        
        return sb2.toString();
    }
}


// import java.util.*;

// class Solution {
//     public String solution(String number, int k) {
//         int chance = k;
        
//         //StringBuilder에 number 추가
//         StringBuilder sb = new StringBuilder();
//         sb.append(number);
    
        
//         //앞자리수 제거
//         int i = 0;
//         while (i < sb.length() - 1) {
//             if (chance <= 0) break; 

//             if (sb.charAt(i) < sb.charAt(i + 1)) {
//                 sb.deleteCharAt(i);
//                 chance--;
//                 i = 0; // for문의 i = -1과 동일 (삭제했으므로 처음부터 다시 검사)
//             } else {
//                 i++; // 삭제하지 않았을 때만 다음 인덱스로 이동
//             }
//         }

//         sb.reverse();

//         // 두 번째 루프
//         i = 0; // i 초기화
//         while (i < sb.length() - 1) {
//             if (chance <= 0) break;

//             if (sb.charAt(i) < sb.charAt(i + 1)) {
//                 sb.deleteCharAt(i);
//                 chance--;
//                 i = 0; // 처음부터 다시 검사
//             } else {
//                 i++;
//             }
//         }

//         sb.reverse();
        
        
        
//         //10, 12번 반례 찾기
        
//         String answer = sb.toString();
        
//         return answer;
        
//     }
// }