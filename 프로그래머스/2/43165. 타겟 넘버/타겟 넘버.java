class Solution {
    static boolean[] visited;
    static int answer;
    public void dfs(int level, int now, int target, int[] numbers){
        if(level == numbers.length){
            if(now == target){
                answer++;
                return;
            }else{
                return;
            }
        } else{
            dfs(level + 1, now + numbers[level], target, numbers);
            dfs(level + 1, now - numbers[level], target, numbers);
        }
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        visited = new boolean[numbers.length];
        dfs(0, 0, target, numbers);
        return answer;
    }
}