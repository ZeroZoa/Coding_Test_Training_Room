import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 1. 전체 보석 종류 개수 파악
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int totalTypes = set.size();
        
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0; // 정답 구간의 시작 인덱스
        
        HashMap<String, Integer> currentMap = new HashMap<>();
        
        //투 포인터 탐색
        while (true) {
            //모든 종류의 보석을 찾은 경우 -> 구간을 줄여본다 (left 이동)
            if (currentMap.size() == totalTypes) {
                // 최소 길이 갱신
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                // left가 가리키는 보석을 맵에서 제거하거나 개수 감소
                String leftGem = gems[left];
                if (currentMap.get(leftGem) == 1) {
                    currentMap.remove(leftGem); // 1개뿐이면 아예 삭제해서 size를 줄임
                } else {
                    currentMap.put(leftGem, currentMap.get(leftGem) - 1);
                }
                left++; // 윈도우 축소
            } 
            //right가 끝까지 도달했는데 보석 종류도 부족한 경우 -> 종료
            else if (right == gems.length) {
                break;
            } 
            //보석 종류가 부족한 경우 -> 구간을 늘린다 (right 이동)
            else {
                String rightGem = gems[right];
                currentMap.put(rightGem, currentMap.getOrDefault(rightGem, 0) + 1);
                right++; // 윈도우 확장
            }
        }
        
        return new int[]{start + 1, start + minLen};
    }
}