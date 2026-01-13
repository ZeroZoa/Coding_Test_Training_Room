class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        //map 웅덩이 추가
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        //map 가로 첫줄 0 or 1 -> 웅덩이 존재에 따라
        for(int i = 0;i<map[0].length;i++){
            if(i == 0){
                map[0][i] = 1;
                
            }else{
                if(map[0][i] == -1){
                    continue;
                }else{
                    if(map[0][i-1] == 1){
                        map[0][i] = 1;
                    }else{
                        map[0][i] = 0;
                    }
                }
            }
        }
        
        //map 세로 첫줄 0 or 1 -> 웅덩이 존재에 따라
        for(int i = 0;i < map.length; i++){
            for(int j = 0; j < 1; j++){
                if(i==0){
                    map[i][j] = 1;
                }else{
                    if(map[i][j] == -1){
                        continue;
                    }else{
                        if(map[i-1][j] == 1){
                            map[i][j] = 1;
                        }else{
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }
        
        //반복문을 통해 계산
        for(int i = 1; i < map.length; i++){
            for(int j = 1; j < map[i].length; j++){
                if(map[i][j] == -1){
                    continue;
                }else{
                    if(map[i-1][j] == -1 && map[i][j-1] == -1){
                        map[i][j] = 0;
                    }else if(map[i-1][j] == -1 && map[i][j-1] > -1){
                        map[i][j] = map[i][j-1];
                        map[i][j] = map[i][j] % 1000000007;
                    }else if(map[i-1][j] > -1 && map[i][j-1] == -1){
                        map[i][j] = map[i-1][j];
                        map[i][j] = map[i][j] % 1000000007;
                    }else{
                        map[i][j] = map[i-1][j] + map[i][j-1];
                        map[i][j] = map[i][j] % 1000000007;
                    }
                }
            }
        }
        
        
        return map[n-1][m-1];
    }
}