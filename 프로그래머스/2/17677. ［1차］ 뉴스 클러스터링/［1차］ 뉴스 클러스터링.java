import java.util.*;

class Solution {
    public double solution(String str1, String str2) {
        //대문자 소문자는 구분X
        String upperStr1 = str1.toUpperCase();
        String upperStr2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        //str1 2글자씩 분리
        for(int i = 0; i < upperStr1.length() - 1; i++){
            String temp = upperStr1.substring(i,i+2);
            if('A' <= temp.charAt(0) && 
               temp.charAt(0) <= 'Z' &&
               'A' <= temp.charAt(1) &&
               temp.charAt(1) <= 'Z' ){
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            }
        }
        
        //str2 2글자씩 분리
        for(int i = 0; i < upperStr2.length() - 1; i++){
            String temp = upperStr2.substring(i,i+2);
            if('A' <= temp.charAt(0) && 
               temp.charAt(0) <= 'Z' &&
               'A' <= temp.charAt(1) &&
               temp.charAt(1) <= 'Z' ){
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }
        //합집합 구하기
        HashMap<String, Integer> union = new HashMap<>();
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            Integer v1 = map1.get(key);
            Integer v2 = map2.get(key);

            if (v1 != null && v2 != null) {
                // 두 값 중 더 큰 값 선택
                union.put(key, Math.max(v1, v2));
            } else if (v1 != null) {
                union.put(key, v1);
            } else {
                union.put(key, v2);
            }
        }

        //교집합 구하기
        HashMap<String, Integer> intersection = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                // 두 값 중 더 작은 값 선택
                if (map1.get(key) <= map2.get(key)) {
                    intersection.put(key, map1.get(key));
                } else {
                    intersection.put(key, map2.get(key));
                }
            }
        }
        
        double unionSize = 0;
        for (String key : union.keySet()) {
            unionSize += union.get(key);
        }

        double intersectionSize = 0;
        for (String key : intersection.keySet()) {
            intersectionSize += intersection.get(key);
        }
        
        if(intersectionSize == 0 && unionSize == 0){
            return 65536;
        }
        
        if(intersectionSize == 0 && unionSize > 0){
            return 0;
        }
        
         return (int)((double)intersectionSize / unionSize * 65536);
    }
}