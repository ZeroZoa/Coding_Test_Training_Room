class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 100000;
        int min = 1;
        int answer = max;
        //걸린 시간
        long time;
        //레벨
        int level;
        while(min <= max){
            level = (min + max) / 2;
            time = 0;
            for(int j = 0;j < diffs.length; j++){
                if(diffs[j] <= level){
                    time = time + times[j];
                }else{
                    time = time + (diffs[j]-level)*(times[j]+times[j-1])+times[j];
                }
            }
            if(time <= limit){//레벨이 너무 높으면
                answer = level;   // 현재 레벨로 가능하므로 저장
                max = level - 1;
            }else{//레벨이 너무 낮으면
                min = level + 1;
            }
        }
        return answer;
    }
}
