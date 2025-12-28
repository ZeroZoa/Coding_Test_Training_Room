import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int totalDay = 0;
        int temp = 0;
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        // key-value 저장
        for (int i = 0; i < number.length; i++) {
            map.put(want[i], number[i]);
        }

        // 원하는 물품 총 개수(날짜)
        for (int i = 0; i < number.length; i++) {
            totalDay += number[i];
        }

        // 첫날부터 반복
        for (int i = 0; i <= discount.length - totalDay; i++) {
            // 매번 초기화
            for (int t = 0; t < number.length; t++) {
                map.put(want[t], number[t]);
            }

            // 세일 계획 반복
            for (int j = 0; j < totalDay; j++) {
                for (int k = 0; k < want.length; k++) {
                    if (discount[i + j].equals(want[k])) { 
                        int value = map.get(want[k]);
                        map.put(want[k], value - 1);
                    }
                }
            }

            temp = 0;
            for (int q = 0; q < want.length; q++) {
                if (map.get(want[q]) != 0) {
                    break;
                } else {
                    temp++;
                }
            }

            if (temp == want.length) {
                answer++;
            }
        }

        return answer;
    }
}