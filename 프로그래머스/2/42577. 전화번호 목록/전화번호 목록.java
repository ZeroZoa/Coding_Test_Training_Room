import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int count = 0;
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(String str : set){
            for(int i=1; i<=str.length(); i++){
                String sub = str.substring(0, i);
                
                if(set.contains(sub) && !sub.equals(str)){
                    return false;
                }
            } 
        }
        return true;
    }
}