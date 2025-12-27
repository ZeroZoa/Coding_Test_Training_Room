import java.util.*;

class Song{
    String genres;
    int plays;
    int index;
    
    public Song(String genres, int plays, int index){
        this.genres = genres;
        this.plays = plays;
        this.index = index;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> temp = new ArrayList<>();
        
        int count = 0;
        //장르-장르별 플레이수 정렬
        HashMap<String, Integer> genreList = new HashMap<>();
        for(int i=0;i<plays.length;i++){
            genreList.put(genres[i], genreList.getOrDefault(genres[i], 0) + plays[i]);
        }
        //정렬
        List<String> keySet = new ArrayList<>(genreList.keySet());
        keySet.sort((o1, o2) -> genreList.get(o2) - genreList.get(o1));
        
        //플레이수 기준으로 노래 정렬
        List<Song> songList = new ArrayList<>();
        for(int i=0;i<plays.length;i++){
            songList.add(new Song(genres[i], plays[i], i));
        }
        //정렬
        songList.sort((o1, o2) -> o2.plays - o1.plays);
        
        for(int i=0;i<keySet.size();i++){
            count=0;
            for(int j=0; j<songList.size();j++){
                if(keySet.get(i).equals(songList.get(j).genres)){
                    if(count < 2){
                        temp.add(songList.get(j).index);
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        int[] answer = new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            answer[i]=temp.get(i);
        }
        return answer;
    }
}