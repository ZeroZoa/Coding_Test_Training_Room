class Solution {
    public int solution(int n, int w, int num) {
        int h = n / w + 1;
        int[][] room = new int[h][w];   
        int box = 1;
        int ilocation = 0;              
        int jlocation = 0;              
        int answer = 1;
        
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    room[h - i - 1][j] = box++;
                }
            } else {
                for (int j = 0; j < w; j++) {
                    room[h - i - 1][w-1-j] = box++;
                }
            }
        }
        
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (room[i][j] == num) {
                    ilocation = i;
                    jlocation = j;
                    break;
                }
            }
        }
        
        while(ilocation - 1 >= 0){
            if(room[--ilocation][jlocation] <= n){
                answer++;
            }
        }
        
        return answer;
    }
}