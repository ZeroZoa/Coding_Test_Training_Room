import java.util.*;

class History {
    int inTime;
    int totalTime;
    int carNum;
    
    public History(int inTime, int totalTime, int carNum) {
        this.inTime = inTime;
        this.totalTime = totalTime;
        this.carNum = carNum;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 입차 중인 차량 리스트
        Map<Integer, History> list = new HashMap<>();
        // 최종 누적 시간을 저장할 맵 (TreeMap을 사용하여 차량번호순 자동 정렬)
        Map<Integer, History> answer = new TreeMap<>();
        
        for (String recordStr : records) {
            String[] record = recordStr.split(" ");
            String[] time = record[0].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int currentTime = h * 60 + m;
            int carNum = Integer.parseInt(record[1]);
            
            if (record[2].equals("IN")) {
                // 이미 들어왔다 나간 기록이 있는 경우 기존 totalTime 유지
                int prevTotal = answer.containsKey(carNum) ? answer.get(carNum).totalTime : 0;
                list.put(carNum, new History(currentTime, prevTotal, carNum));
            } else {
                // OUT인 경우: 입차 기록을 가져와서 누적 시간 계산 후 answer에 저장
                History car = list.get(carNum);
                list.remove(carNum);
                int duration = currentTime - car.inTime;
                answer.put(carNum, new History(0, car.totalTime + duration, carNum));
            }
        }
        
        
        for (Integer key : list.keySet()) {
            History value = list.get(key);
            int duration = 1439 - value.inTime;
            answer.put(key, new History(0, value.totalTime + duration, key));
        }

        int[] result = new int[answer.size()];
        int idx = 0;
        for (Integer key : answer.keySet()) {
            History value = answer.get(key);
            int totalTime = value.totalTime;
            
            if (totalTime <= fees[0]) {
                // 기본 시간 이하
                result[idx] = fees[1];
            } else {
                // 초과 요금 계산 (올림 처리)
                int extraTime = totalTime - fees[0];
                int units = (extraTime + fees[2] - 1) / fees[2];
                result[idx] = fees[1] + (units * fees[3]);
            }
            idx++;
        }
        
        return result;            
    }
}