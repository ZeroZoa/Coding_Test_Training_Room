import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int total = 1;
        
        Map<String, Integer> map1 = new HashMap<>();
        
        //의상 <카테고리, 갯수>로 저장
        for(int i=0; i<clothes.length;i++){
            map1.put(clothes[i][1], map1.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(int count : map1.values()){
            total *= count+1;
        }
        
        return total-1;
    }
}