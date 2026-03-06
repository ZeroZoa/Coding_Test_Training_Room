import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter")){
                count++;
                map.put(temp[1], temp[2]);
            }else if(temp[0].equals("Change")){
                map.put(temp[1], temp[2]);
            }else{
                count++;
                continue;
            }
        }
        
        String[] answer = new String[count];
        
        int index = 0;
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            String name = map.get(temp[1]);
            if(temp[0].equals("Enter")){
                answer[index] = name +"님이 들어왔습니다.";
                index++;
            }else if(temp[0].equals("Leave")){
                answer[index] = name +"님이 나갔습니다.";
                index++;
            }
        }
        return answer;
    }
}