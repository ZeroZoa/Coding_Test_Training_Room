import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++){
            
            for(int j = 0; j < elements.length; j++){
                int temp = 0;
                for(int k = 0; k <= j; k++){
                    if(i + k >= elements.length){
                        temp += elements[(i + k) % elements.length];
                    }else{
                        temp += elements[i + k];
                    }
                }
                set.add(temp);
            }
        }
        return set.size();
    }
}