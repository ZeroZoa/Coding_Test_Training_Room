class Solution {
    static int answer = 0;
    
    public void dfs(int[] numbers, int target, int depth, int current){
        if(depth == numbers.length){
            if(current == target){
                answer++;
            } 
            return;
        }
        
        dfs(numbers, target, depth + 1, current + numbers[depth]);
        dfs(numbers, target, depth + 1, current - numbers[depth]);
        
        
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}