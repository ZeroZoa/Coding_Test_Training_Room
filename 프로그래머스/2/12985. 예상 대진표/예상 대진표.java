class Solution {
    int cal(int n){
        if(n % 2 == 0){
            n = n / 2;
        }else{
            n = (n + 1) / 2;
        }
        return n;
    }
    
    public int solution(int n, int a, int b) {
        
        int round = (int)(Math.log(n) / Math.log(2));

        for(int i = 1; i < round + 1; i++){
            if(cal(a) == cal(b)){
                return i;
            }else{
                a = cal(a);
                b = cal(b);
            }
        }
        int answer = 0;
        return answer;
    }
}