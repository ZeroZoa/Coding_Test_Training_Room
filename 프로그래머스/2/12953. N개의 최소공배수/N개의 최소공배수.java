class Solution {
    public long solution(int[] arr) {
        long flag = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            flag = getLcm(flag, arr[i]);
        }
        
        return flag;
    }
    
    long getGcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    long getLcm(long a, long b){
        return (a / getGcd(a, b)) * b;
    }
    
    
}