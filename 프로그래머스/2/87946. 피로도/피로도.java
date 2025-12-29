class Solution {
    static int max=-1;
    public void dfs(int k, int depth, boolean[] visit, int[][] dungeons){
        if(k>0){
            depth++;
            if(max<depth){
                max=depth;
            }
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(!visit[i]){
                visit[i] = true;
                if(k>dungeons[i][0]){
                    dfs(k-dungeons[i][1], depth, visit, dungeons);
                }
                visit[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        dfs(k, 0, visit, dungeons);
        return max;
    }
}