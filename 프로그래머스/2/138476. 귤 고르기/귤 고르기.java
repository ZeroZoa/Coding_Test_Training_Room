import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int answer = 0;
        int chance = k;
        
        for (Map.Entry<Integer, Integer> entry : list) {
            if(chance > 0){
                if(entry.getValue() <= chance){
                    answer++;
                    chance = chance - entry.getValue();
                }else{
                    answer++;
                    chance = 0;
                }
            }else{
                break;
            }
        }
        
        return answer;
    }
}