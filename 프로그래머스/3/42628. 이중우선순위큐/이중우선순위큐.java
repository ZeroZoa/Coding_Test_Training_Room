import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        //들어오는 값을 오름차순으로 정렬
        TreeSet<Integer> set = new TreeSet<>();
        
        //우선순위 큐 반복문 시작
        for(int i =0; i<operations.length;i++){
            String[] parts = operations[i].split(" ");
            String letter = parts[0]; //명령어와
            int number = Integer.parseInt(parts[1]); // 숫자로 분리
            
            if(letter.equals("D")){//Delete연산
                if(set.size() == 0){//비어있으면 걍 뛰어넘기
                    continue;
                } else{//비어있지 않으면 사게
                    if(number == 1){//최대값 삭제라면
                        set.pollLast();
                    }else{//최솟값 삭제라면
                        set.pollFirst();
                    }
                }
            }else{//Add연산
                set.add(number);
            }
        }
        
        int first = 0;
        int second = 0;
        if(set.size()==1){
            first = set.pollFirst();
            second = first;
        } else if(set.size() >= 2){
            first = set.pollLast();
            second = set.pollFirst();
        } else if(set.size() == 0){
            first = 0;
            second = 0;
        } 
        int[] answer = {first, second};
        return answer;
    }
}