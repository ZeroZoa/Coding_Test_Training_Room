import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //가장 첫 줄 빌딩의 갯수 저장
        int N = Integer.parseInt(br.readLine());
        //빌딩을 지을때 선결해야할 빌딩을 저장할 2차원 
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
 
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
 
        int[] indegree = new int[N + 1]; // 특정 빌딩을 짓기 전에 먼저 지어야 할 빌딩의 개수
        int[] time = new int[N + 1]; // 특정 빌딩을 짓는 데 걸리는 시간
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            //제일 첫 토큰 = 빌딩 짓는데 걸리는 시간 -> 저장
            time[i] = Integer.parseInt(st.nextToken());

            
            while (true) {
                //반복문을 통해 다음 토큰 = 선결해야할 빌딩 번호 저장
                int num = Integer.parseInt(st.nextToken());

                //빌딩이 없으면 종료
                if (num == -1) {
                    break;
                }

                //i번쨰 빌딩을 건설하려면 num을 끝내야함
                //각 빌딩 번호를 기준으로 선결해야할 빌딩=i 추가
                arr.get(num).add(i);

                //선결해야할 빌딩 갯수 추가
                indegree[i]++;
            }
        }
 
        String answer = sort(arr, indegree, time, N);
 
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static String sort(ArrayList<ArrayList<Integer>> arr, int[] indegree, int[] times, int N) {
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            //빌딩에 선결해야할 빌딩이 없으면 큐에 추가
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        //결과를 저장할 배열(빌딩 번호)
        int[] result = new int[N + 1];
 
        while (!queue.isEmpty()) {
            int now = queue.poll();

            //리스트에서 선결된 빌딩(now)
            for (int next : arr.get(now)) {
                indegree[next]--;
                
                //next 건물을 짓기 전까지 걸린 시간 계산
                result[next] = Math.max(result[next], result[now] + times[now]);
 
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        // 특정 건물을 짓는 데 걸린 시간을 출력.
        for (int i = 1; i <= N; i++) {
            sb.append((result[i] + times[i]) + "\n");
        }
 
        return sb.toString();
    }
}
