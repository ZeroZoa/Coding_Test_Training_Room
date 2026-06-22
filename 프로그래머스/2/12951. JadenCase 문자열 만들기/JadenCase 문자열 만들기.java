class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            if(i == 0){ //첫 글자라면 대문자 변환
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    sb.append((char)(s.charAt(i) - 32));
                }else{
                    sb.append(s.charAt(i));
                }
            } else{ //첫 글자가 아니라면
                if(s.charAt(i - 1) == ' '){
                    if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                        sb.append((char)(s.charAt(i) - 32));
                    }else{
                        sb.append(s.charAt(i));
                    }
                } else{
                    if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                        sb.append((char)(s.charAt(i) + 32));
                    }else{
                        sb.append(s.charAt(i));
                    }
                }
            }
        }
        String answer = sb.toString();
        return answer;
    }
}