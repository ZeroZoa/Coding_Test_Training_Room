import java.util.*;

class Solution {
    public void dfs(int count,  boolean[] used, String[][] tickets, LinkedList<String> path, ArrayList<String[]> results){
        if(count == tickets.length){
            results.add(path.toArray(new String[0]));
            return;
        }else{
            for(int i = 0; i < tickets.length; i++){
                if(!used[i] && tickets[i][0].equals(path.peekLast())){
                    path.add(tickets[i][1]);
                    used[i] = true;
                    dfs(count + 1, used, tickets, path, results);
                    path.pollLast();
                    used[i] = false;
                }
            }
        }
        return;
    }
    
    public String[] solution(String[][] tickets) {
        ArrayList<String[]> results = new ArrayList<>();
        
        
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                LinkedList<String> path = new LinkedList<>();
                boolean[] used = new boolean[tickets.length];
                
                path.add(tickets[i][0]);
                path.add(tickets[i][1]);
                used[i] = true;
                
                dfs(1, used, tickets, path, results);
            }
        }
        
        Collections.sort(results, (a, b) -> {
            for (int i = 0; i < a.length && i < b.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.length, b.length);
        });

        return results.get(0);
    }
}