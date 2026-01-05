import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n];
        //잃어버린 체육복 -1만들기
        for(int i=0; i<lost.length; i++){
            student[lost[i]-1]--;
        }
        
        for(int i=0; i<reserve.length; i++){
            student[reserve[i]-1]++;
        }
        
        for(int i=0; i<student.length; i++){
            //잃어버린 학생이라면
            if(student[i] == -1){
                if(i>0 && student[i-1] == 1){
                    student[i]++;
                    student[i-1]--;
                }
                else if(i<student.length-1 && student[i+1] == 1){
                    student[i]++;
                    student[i+1]--;
                }
            }
        }
        
        for(int i=0; i<student.length; i++){
            if(student[i] >= 0){
                answer++;
            }
        }
        
        return answer;
    }
}