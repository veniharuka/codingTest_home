import java.util.*;
class Solution {
    public int solution(int n, int[][] computers){
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if (visited[i]) continue;
            dfs(n,computers, visited,i);
            cnt++;
        }
        return cnt;
    }
    
    void dfs(int n, int[][] computers, boolean[] visited, int cur){
        visited[cur] = true;
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[cur][i]==1){
                dfs(n,computers,visited,i);
            }
        }
    }
    
    
    
}