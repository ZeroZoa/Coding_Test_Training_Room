class Solution {
    //max값 저장
    static int max=-1;
    //dfs 재귀함수
    public void dfs(int now, int depth, boolean[] visit, int[][] triangle, int location){
        if(max < now){
            max = now;
        }
        if(depth<triangle.length-1){
            depth++; 
            if(!visit[depth]){
                visit[depth] = true;
                dfs(now+triangle[depth][location], depth, visit, triangle, location);
                visit[depth] = false;

                visit[depth] = true;
                dfs(now+triangle[depth][location+1], depth, visit, triangle, location+1);
                visit[depth] = false;
            }  
        }
    }
    
    public int solution(int[][] triangle) {
        boolean[] visit = new boolean[triangle.length];
        visit[0]=true;
        dfs(triangle[0][0], 0, visit, triangle, 0);
        return max;
    }
}
