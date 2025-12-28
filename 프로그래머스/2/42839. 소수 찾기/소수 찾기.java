import java.util.*;

class Solution {
    //소수를 저장하고있는 Set
    Set<Integer> primeSet = new HashSet<>();
    
    //소수 구하기 소수라면 true 소수가 아니라면 false 반환
    public boolean isPrime(int num){
        if(num==1||num==0){
            return false;
        }
        for(int i = 2;i <= (int)Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    //dfs로 숫자 조합 순열 만들기
    public void dfs(String[] arr, boolean[] visit, String status){
        if(!status.equals("")){
            int num = Integer.parseInt(status);
            if(isPrime(num)){
                primeSet.add(num);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(arr, visit, status + arr[i]);
                visit[i] = false;
            }
        }
    }
    
    //메인
    public int solution(String numbers) {
        primeSet.clear(); // 전역 변수 초기화 (프로그래머스 등에서는 필수)
        boolean[] visit = new boolean[numbers.length()];
        String[] strArr = numbers.split("");
        
        dfs(strArr, visit, "");
        
        // Set의 크기가 곧 소수의 개수
        return primeSet.size();
    }
}