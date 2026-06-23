class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        int round = 0;
        int removedZero = 0;
        
        //라운드 반복
        while(sb.length() > 1){
            round++;
            int zero = 0;
            int one = 0;
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) == '0'){
                    zero++;
                }else{
                    one++;
                }
            }
            // 0갯수 카운트
            removedZero +=zero;
            
            //sb초기화 및 init
            sb.setLength(0);
            
            // 1갯수 이진수 변환
            int amount = 0;
            while(one >= 1){
                amount = one % 2;
                sb.append(amount);
                one = one / 2;
            }
            sb.reverse();
        }
        
        answer[0] = round;
        answer[1] = removedZero;
        
        return answer;
    }
}