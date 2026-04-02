import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
 
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
 
        int[] indegree = new int[N + 1]; // 특정 건물을 짓기 전에 먼저 지어야 할 건물의 개수
        int[] time = new int[N + 1]; // 특정 건물을 짓는 데 걸리는 시간
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
 
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
 
                if (num == -1) {
                    break;
                }
 
                arr.get(num).add(i);
 
                indegree[i]++;
            }
        }
 
        String answer = topologicalSort(arr, indegree, time, N);
 
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static String topologicalSort(ArrayList<ArrayList<Integer>> arr, int[] indegree, int[] times, int N) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
 
        while (!queue.isEmpty()) {
            int now = queue.poll();
 
            for (int next : arr.get(now)) {
                indegree[next]--;
                
                // next 건물을 짓기 전까지 걸린 시간 계산.
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