import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] ui;
    static String[] bi;
    static int answer;
    static HashSet<HashSet<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        ui = user_id;
        bi = banned_id;
        visited = new boolean[ui.length];
        result = new HashSet<>();
        dfs(0);
            
        return result.size();
    }
    
    public void dfs(int depth){
        if(depth == bi.length){
            HashSet<String> temp = new HashSet<>();
            
            for(int i = 0; i < ui.length; i++){
                if(visited[i]){
                    temp.add(ui[i]);
                }
            }
            
            result.add(temp);
        }else{
            for(int i = 0; i < ui.length; i++){
                if(!visited[i]){
                    if(checkPoss(bi[depth], ui[i])){
                        visited[i] = true;
                        dfs(depth + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }
    
    //제재아이디에 해당하는지 확인하는 함수
    public boolean checkPoss(String banned_id, String user_id){
        int banLen = banned_id.length();
        int userLen = user_id.length();
        
        if(banLen == userLen){
            for(int i = 0; i < userLen; i++){
                if(banned_id.charAt(i) == user_id.charAt(i) || banned_id.charAt(i) == '*'){
                    continue;
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
        
        return true;
    }
}