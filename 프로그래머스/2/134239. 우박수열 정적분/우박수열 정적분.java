class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        //n구하기
        int n = 0;
        int saveK = k;
        
        while(saveK != 1){
            if(saveK % 2 == 0){ //1-1
                saveK = saveK / 2;
            }else{ //1-2
                saveK = saveK * 3 + 1;
            }
            n++;
        }
        
        double[] sizeList = new double[n];
        double temp1 = k;
        double temp2 = 0;
        
        //각 넓이 구해놓기
        for(int i = 0; i < n; i++){
            if(temp1 % 2 == 0){
                temp2 = temp1 / 2;
            }else{
                temp2 = temp1 * 3 + 1;
            }
            
            sizeList[i] = ((temp1 + temp2) / 2);
            
            temp1 = temp2;
        }
        
        double[] answer = new double[ranges.length];
        
        for(int i = 0; i < ranges.length; i++){
            double size = 0;
            if(ranges[i][0] > n + ranges[i][1]){
                size = -1;
            }else{
                for(int j = ranges[i][0]; j < n + ranges[i][1]; j++){
                    size = size + sizeList[j];
                }
            }
            answer[i] = size;
        }
        return answer;
    }
}