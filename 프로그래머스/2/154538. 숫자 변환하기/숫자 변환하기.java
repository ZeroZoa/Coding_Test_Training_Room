import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, 1000000);

        for(int i = x; i <= y; i++){
            if(i == x){
                dp[i] = 0;
                if(i * 2 <= y){
                    dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
                }
                if(i * 3 <= y){
                    dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
                }
                if(i + n <= y){
                    dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
                }
            } else{
                if(dp[i]==1000000){
                    continue;
                }else{
                    if(i * 2 <= y){
                    dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
                    }
                    if(i * 3 <= y){
                        dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
                    }
                    if(i + n <= y){
                        dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
                    }
                }
            }
        }
        if(dp[y] == 1000000){
            return -1;
        }
        return dp[y];
    }
}