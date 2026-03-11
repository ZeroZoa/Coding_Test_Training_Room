import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        //스킬+순서를 저장할 map
        Map<Character, Integer> map = new HashMap<>() ;
        
        //스킬 저장해놓기
        for(int i = 0; i < skill.length(); i++){
            map.put(skill.charAt(i), i);
        }
        //불가한 스킬 카운트
        int count = 0; 
        
        for(int i = 0; i < skill_trees.length; i++ ){
            //스킬 순서 인덱스
            int index = 0;
            for(int j = 0; j < skill_trees[i].length(); j++){
                if(map.containsKey(skill_trees[i].charAt(j))){ //알파벳이 스킬에 존재한다면
                    if(map.get(skill_trees[i].charAt(j)) == index){
                        index++;
                    }else{
                        count++;
                        break;
                    }
                }
            }
        } 
        return skill_trees.length - count;
    }
}