import java.util.*;

public class Job{
    int requestTime;
    int workingTime;
    int index;
    
    public Job(int requestTime, int workingTime, int index){
        this.requestTime=requestTime;
        this.workingTime=workingTime;
        this.index=index;
    }
}
class Solution {
    //가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 
    //이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 
    //작업의 번호가 작은 것 순으로 우선순위가 높습니다.
    public int solution(int[][] jobs) {
        int count = 0;
        int answer = 0;
        int currentTime = 0;
        int jobIdx = 0;
        //작업 Map에 넣기
        ArrayList<Job> jobList = new ArrayList<>();
        for(int i=0; i<jobs.length; i++){
            jobList.add(new Job(jobs[i][0], jobs[i][1], i));
        }
                    
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.workingTime != b.workingTime) {
                    return a.workingTime - b.workingTime;
                } else if (a.requestTime != b.requestTime) {
                    return a.requestTime - b.requestTime;
                } else {
                    return a.index - b.index;
                }
            }
        );
        
        while(count < jobs.length){
            //현재시간보다 요청시간이 먼저라면 큐에 추가 //answer++
            for(int i=0; i<jobList.size(); i++){
                if(jobList.get(i).requestTime <= currentTime){
                    pq.offer(jobList.get(i));
                    jobList.remove(i);
                    i--;
                }
            }
            
            if(!pq.isEmpty()){//큐가 비어있지 않다면
                Job job = pq.poll();
                currentTime +=job.workingTime;
                answer += currentTime - job.requestTime;
                count++;
            }else{//큐가 비어있다면
                if(count >= jobs.length){
                    break;
                }else{
                    currentTime++;
                }
            }
        }
        return answer/jobs.length;
    }
}
