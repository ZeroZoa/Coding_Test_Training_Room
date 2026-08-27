import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            //순서가 바뀐 문자열을 저장할 StringBuilder
            StringBuilder sb = new StringBuilder();
            
            //올바른 괄호를 판단할 스택
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            //순서를 조정한 StringBuilder 만들기
            for(int j = 0; j < s.length(); j++){
                sb.append(s.charAt((i + j) % s.length()));
            }
            
            //문자열을 순회하면 올바른 괄호인지 확인
            for(int j = 0; j < sb.length(); j++){
                if(stack.isEmpty()){ //스택이 비어있으면
                    if(sb.charAt(j) == ')' || sb.charAt(j) == '}' || sb.charAt(j) == ']'){
                        stack.push(sb.charAt(j));
                        break;
                    }else{
                        stack.push(sb.charAt(j));
                    }
                }else{ // 스택이 비어있지 않다면
                    if(sb.charAt(j) == ')' || sb.charAt(j) == '}' || sb.charAt(j) == ']'){
                        if(sb.charAt(j) == ')' && stack.peek()=='('){
                            stack.pop();
                        }else if(sb.charAt(j) == '}' && stack.peek()=='{'){
                            stack.pop();
                        }else if(sb.charAt(j) == ']' && stack.peek()=='['){
                            stack.pop();
                        }else{
                            break;
                        }
                    }else{
                        stack.push(sb.charAt(j));
                    }
                }
            }
            
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}