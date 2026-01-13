import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        
        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(i==0){
                    dp[i][0] = triangle[0][0];
                }else{
                    if(j==0){
                        dp[i][j] = dp[i-1][j] + triangle[i][j];
                    }else if(j == triangle[i].length - 1){
                        dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                    }
                }
            }
        } 
        
        //최대값 찾기
        int max = 0;
        for(int j = 0; j < triangle.length; j++){
            if(dp[triangle.length -1][j] > max){
                max = dp[triangle.length -1][j];
            }
        }
        return max;
    }
}