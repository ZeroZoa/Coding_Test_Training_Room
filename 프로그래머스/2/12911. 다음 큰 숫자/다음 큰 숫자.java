import java.lang.Integer;

class Solution {
    int countOne(String num){
        int count = 0;
        
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '1'){
                count++;
            }
        }
        
        return count;
    }
    public int solution(int n) {
        int num = n + 1;
        String temp = Integer.toBinaryString(n);
        
        int flag = countOne(temp);
        
        while(true){
            if(countOne(Integer.toBinaryString(num)) == flag){
                break;
            }else{
                num++;
            }
        }
        return num;
    }
}