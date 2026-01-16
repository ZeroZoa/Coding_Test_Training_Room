import java.util.*;

class Solution {
    public int solution(int N, int number) {
        //DP 생성 및 초기화
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        int num = N;
        for(int i = 1; i <= 8; i++){
            num = (int)(N * (Math.pow(10, i) - 1) / 9);
            dp.get(i).add(num);
            for(int j = 1; j < i;j++){
                for (int a: dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                        if (a != 0) dp.get(i).add(b / a);
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }    
        }
        return -1;
    }
}