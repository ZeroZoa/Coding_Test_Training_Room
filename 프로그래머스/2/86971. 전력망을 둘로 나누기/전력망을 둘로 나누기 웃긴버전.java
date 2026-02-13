import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = wires.length - 1;
        int temp = wires.length - 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n - 1; i++){ //간선 개수만큼 반복
            //set으로 중복 제거 + 전력망 분리
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.isEmpty()){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }else if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = 0; j < n - 1; j++){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            for(int j = n - 2; j >= 0; j--){
                if(i == j){
                    continue;
                }else{
                    if(set.contains(wires[j][0]) || set.contains(wires[j][1])){
                        set.add(wires[j][0]);
                        set.add(wires[j][1]);
                    }
                }
            }
            int other = n - set.size();
            
            if(other > set.size()){
                temp = other - set.size();
            }else{
                temp = set.size() - other;
            }
            
            //최소값 업데이트
            if(temp < min){
                min = temp;
            }
            
            //초기화
            set.clear();
        }
        return min;
    }
}
