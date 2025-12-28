import java.util.Stack;


class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //스택이 비어있으면 무조건 푸쉬
            if(stack.isEmpty()){
                stack.push(c);
            //비어있지 않다면 확인해야죠
            } else{
                if(c == '('){
                    stack.push(c);
                // 이번 괄호가 ')' 이면
                }else{
                    if(stack.peek() == '('){
                        stack.pop();
                    // ( 이면
                    } else{
                        stack.push(c);
                    }
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        
        

        return answer;
    }
}