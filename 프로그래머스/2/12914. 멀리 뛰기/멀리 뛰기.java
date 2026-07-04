class Solution {
    public long solution(int n) {
        int[] x = new int[3000];
        x[0] = 0;
        x[1] = 1;
        x[2] = 2;
        for(int i = 3; i < 3000; i++){
            x[i] = (x[i - 1] + x[i - 2]) % 1234567;
        }
        return x[n];
    }
}