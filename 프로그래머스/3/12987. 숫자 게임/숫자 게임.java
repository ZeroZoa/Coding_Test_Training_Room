import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        //정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int indexA = A.length - 1, indexB = A.length - 1;
        int answer = 0;
        
        while(indexB >= 0 && indexA >= 0){
            if(A[indexA] >= B[indexB]) {
                indexA--;
            }else{
                indexB--;
                indexA--;
                answer++;
            }
        }
       
        return answer;
    }
}