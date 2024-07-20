public class Solution {
    int answer=0;
    int n;
    boolean[] visited;
    
    public int solution(int k , int[][] dungeons){
        n = dungeons.length;
        visited = new boolean[n];
        backtrack(k,0,dungeons);
        return answer;
    }
    
    public void backtrack(int k,int count ,int[][] dungeons){
        if(count>answer) {
            answer = count;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i]&& k>=dungeons[i][0]){
                visited[i]=true;
                backtrack(k-dungeons[i][1],count+1,dungeons);
                visited[i] = false;
            } 
        }
    }
}