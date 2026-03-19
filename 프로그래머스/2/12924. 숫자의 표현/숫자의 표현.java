class Solution {
    public int solution(int n) {
        if(n < 3){
            return 1;
        }
        
        int sum = 1;
        int count = 1;
        
        for(int i = 2; i < 145; i++){
            sum += i;
            if(sum > n){
                return count;
            }
            int temp = n - sum;
            if(temp % i == 0){
                count++;
            }
        }
        
        
        
        return count;
    }
}