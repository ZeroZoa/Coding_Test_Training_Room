class Solution {
    static int count = 0;
    
    void dfs(int[] numbers, int target, int level, int now){
        if(level == numbers.length){
            if(now == target){
                count++;
                return;
            }else{
                return;
            }
        }else{
            dfs(numbers, target, level + 1, now + numbers[level]);
            dfs(numbers, target, level + 1, now - numbers[level]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
}