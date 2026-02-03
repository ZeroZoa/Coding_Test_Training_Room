class Solution {
    public long solution(int n, int[] times) {
        //answer을 기준으로 심사할 수 있는 명수
        long total = 0;
        long answer = 0;
        long right = Long.MAX_VALUE - 1;
        long left = 1;
        long mid = (right + left) / 2;
        
        while(left <= right){
            mid = (right + left) / 2;
            total = 0;
            
            for(int i = 0; i < times.length; i++){
                total = total + mid / times[i];
                if(total >= n) break;
            }
            
            if(total >= n){ //중간 시간이 길면
                answer = mid;
                right = mid - 1;
            }else if(total < n){ //중간 시간이 짧으면
                left = mid + 1;
            }
        }
        return answer;
    }
}