class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 1;
        int min = 1;
        for(int i=0; i<sizes.length;i++){
            if(sizes[i][0] > sizes[i][1]){ //가로가 세로보다 길다면
                if(sizes[i][0]>max){
                    max=sizes[i][0];
                }
                if(sizes[i][1]>min){
                    min=sizes[i][1];
                }
            }else{//가로가 세로보다 짧다면
                if(sizes[i][1]>max){
                    max=sizes[i][1];
                }
                if(sizes[i][0]>min){
                    min=sizes[i][0];
                }
            }
        }
        answer = max*min;
        return answer;
    }
}