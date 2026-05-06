import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length == 1){
            return sticker[0];
        }
        
        if(sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        
        if(sticker.length % 2 == 0){
            //짝수일때
            int[] dpF = new int[sticker.length];
            int[] dpL = new int[sticker.length];
            
            dpF[0] = sticker[0];
            dpF[1] = Math.max(sticker[0], sticker[1]);
            
            for(int i = 2; i < sticker.length - 1; i++){
                dpF[i] = Math.max(dpF[i - 2] + sticker[i], dpF[i - 1]);
            }
            
            dpL[0] = 0;
            dpL[1] = sticker[1];
            
            for(int i = 2; i < sticker.length; i++){
                dpL[i] = Math.max(dpL[i - 2] + sticker[i], dpL[i - 1]);
            }
            
            return Math.max(dpF[sticker.length - 2], dpL[sticker.length - 1]);
            
        } else{//홀수일때
            int[] dpF = new int[sticker.length];
            int[] dpL = new int[sticker.length];
            int[] dpM = new int[sticker.length];
            
            dpF[0] = sticker[0];
            dpF[1] = Math.max(sticker[0], sticker[1]);
            
            for(int i = 2; i < sticker.length - 1; i++){
                dpF[i] = Math.max(dpF[i - 2] + sticker[i], dpF[i - 1]);
            }
            
            dpL[0] = 0;
            dpL[1] = sticker[1];
            
            for(int i = 2; i < sticker.length; i++){
                dpL[i] = Math.max(dpL[i - 2] + sticker[i], dpL[i - 1]);
            }
            
            dpM[0] = 0;
            dpM[1] = sticker[1];
            
            for(int i = 2; i < sticker.length - 1; i++){
                dpM[i] = Math.max(dpL[i - 2] + sticker[i], dpM[i - 1]);
            }
            
            return Math.max(dpF[sticker.length - 2], Math.max(dpL[sticker.length - 1], dpM[sticker.length - 2]));
        }
    }
}