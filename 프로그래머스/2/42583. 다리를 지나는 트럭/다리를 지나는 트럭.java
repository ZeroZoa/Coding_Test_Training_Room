import java.util.*;

class Truck{
    int weight;
    int entryTime;
    
    public Truck(int weight, int entryTime){
        this.weight = weight;
        this.entryTime = entryTime;
        
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int currentWeight = 0;
        int totalTime = 0;
        int carCount = 0;
        
        //다리큐 -> 연결리스트로 사용
        Queue<Truck> bridge = new LinkedList<>();
        
        //다리가 빌때까지 && carCount가 총대수보다 커질때까지 계속
        while(carCount < truck_weights.length || !bridge.isEmpty()){ //비면 false 있으면 true
            totalTime++;
            if(!bridge.isEmpty() && bridge.peek().entryTime + bridge_length==totalTime){ //차량 빼내기
                currentWeight = currentWeight - bridge.poll().weight;
            }
            
            if(carCount < truck_weights.length){
                if(currentWeight + truck_weights[carCount] <= weight && bridge_length > bridge.size()){
                    bridge.offer(new Truck(truck_weights[carCount], totalTime));
                    currentWeight = currentWeight + truck_weights[carCount];
                    carCount++;
                }
            }
        }

        return totalTime;
    }
}