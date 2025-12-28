import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        
        int[] numbers = Arrays.stream(parts)
                              .mapToInt(Integer::parseInt)
                              .toArray();
        
        int MAX=numbers[0];
        int MIN=numbers[0];

        for(int i=0; i<numbers.length;i++){
            if(numbers[i] > MAX){
                MAX = numbers[i];
            }
            if(numbers[i] < MIN){
                MIN = numbers[i];
            }
        }
        
        String answer = String.valueOf(MIN) + " " + String.valueOf(MAX);
        return answer;
    }
}