import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int chance = k;
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        
        for(int i = 0; i < number.length(); i++){
            while(!stack1.isEmpty()&&chance>0&&stack1.peek()<number.charAt(i)){
                stack1.pop();
                chance--;
            }
            stack1.push(number.charAt(i));
        }
        
        StringBuilder sb1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb1.append(stack1.pop());
        }
        
        for(int i = 0; i < sb1.length(); i++){
            while(!stack2.isEmpty()&&chance>0&&stack2.peek()<sb1.charAt(i)){
                stack2.pop();
                chance--;
            }
            stack2.push(sb1.charAt(i));
        }
        
        StringBuilder sb2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb2.append(stack2.pop());
        }
        
        return sb2.toString();
    }
}
