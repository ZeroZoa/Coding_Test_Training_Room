import java.util.*;

class Seller{
    public int total;
    public String referral;
    
    public Seller(int total, String referral){
        this.total = total;
        this.referral = referral;
    }
}
class Solution {
    public void cal(String name, HashMap<String, Seller> map, int profit){
        if(name.equals("-")||profit < 1){
            return;
        }else{
            if(map.containsKey(name)){
                Seller temp = map.get(name);
                int commission = profit / 10;
                temp.total += profit - commission;
                cal(temp.referral, map, commission);
            }
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        //직원 명단 생성 및 초기화
        HashMap<String, Seller> map = new HashMap<>();
        for(int i = 0; i<enroll.length; i++){
            //전체 직원 + 정보를 저장할 리스트
            map.put(enroll[i], new Seller(0, referral[i]));
        }
        

        for(int i = 0; i < seller.length; i++){
            if(map.containsKey(seller[i])){
                int profit = amount[i] * 100;
            cal(seller[i], map, profit);
            }
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i< enroll.length; i++){
            Seller temp = map.get(enroll[i]);
            answer[i] = temp.total;
        }
        return answer;
    }
}