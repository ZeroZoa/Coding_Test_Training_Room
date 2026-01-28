import java.util.*;
class SavePoint{
    public String now;
    public int count;
    
    public SavePoint(String now, int count){
        this.now = now;
        this.count = count;
    }
}
class Solution {
    public boolean isPoss(String begin, String temp){
        int count = 0;
        for(int i = 0; i < begin.length();i++){
            if(begin.charAt(i) != temp.charAt(i)) count++;
        }
        if(count == 1) return true;
        return false;
    }

    public int solution(String begin, String target, String[] words) {
        Deque<SavePoint> queue = new ArrayDeque<>();
        queue.offer(new SavePoint(begin, 0));
        
        while(!queue.isEmpty()){
            SavePoint temp = queue.poll();
            
            if(temp.now.equals(target)){
                return temp.count;
            }else{
                for(int i = 0; i < words.length; i++){
                    boolean result = isPoss(temp.now, words[i]);
                    if(result){
                        queue.offer(new SavePoint(words[i], temp.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}