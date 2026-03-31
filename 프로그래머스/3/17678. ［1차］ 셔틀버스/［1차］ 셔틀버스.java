import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int tempAnswer = 0;
        
        //시간을 계산을 위해 분단위로 변경
        int[] time = new int[timetable.length];
        for(int i = 0; i < timetable.length; i++){
            String[] temp = timetable[i].split(":");
            time[i] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        }
        
        //크루들이 도착하는 시간 오름차순 정렬        
        Arrays.sort(time);
        
        int now = 540;
        int index = 0;
        
        for(int i = 0; i < n; i++){ //셔틀 운행 횟수만큼
            int count = 0;
            while(count < m && index < time.length && time[index] <= now){
                index++;
                count++;
            }
            if(i == n - 1){
                if(count < m){//여유있으면
                    tempAnswer = now;
                }else{//여유없으면
                    tempAnswer = time[index - 1] - 1;
                }
            }
            now += t;
        }
        
        //다른 크루가 너무 늦게 나오면 그냥 셔틀시간에 맞춤
        if(tempAnswer > 540 + (n - 1) * t) {
            tempAnswer = 540 + (n - 1) * t;
        }
        
        
        // 시간과 분 계산
         return String.format("%02d:%02d", tempAnswer / 60, tempAnswer % 60);

    }
}