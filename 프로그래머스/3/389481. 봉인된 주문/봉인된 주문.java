import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        //찾는 주문 보다 앞에 있는 금지 주문 카운팅
        long count = 0;
        //주문을 길이순 -> 알파벳 순으로 정렬
        Arrays.sort(bans, (s1, s2) -> {
            //길이가 다르면 짧은 것이 먼저
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            //길이가 같으면 사전순 비교
            return s1.compareTo(s2);
        });
        
        for (int i = 0; i < bans.length; i++) {
            long temp = 0;
            //문자열을 숫자로 바꾸는 과정
            for (int j = bans[i].length() - 1; j >= 0; j--) {
                // Math.pow 결과를 long으로 캐스팅
                temp += (bans[i].charAt(j) - '`') * (long)Math.pow(26, bans[i].length() - 1 - j);
            }
            //해당 문자열이 주어진 n보다 작으면
            if (temp <= n) {
                n++;
            }else{
                break;
            }
        }
    
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('a' + (n % 26)));
            n /= 26;
        }
        
        return sb.reverse().toString();
    }
}