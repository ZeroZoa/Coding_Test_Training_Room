import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; // 결과 배열 크기 지정

        // 명령어 길이만큼 반복
        for (int i = 0; i < commands.length; i++) {
            // 부분 배열 추출
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp); // 정렬
            answer[i] = temp[commands[i][2] - 1]; // k번째 값 저장
        }

        return answer;
    }
}