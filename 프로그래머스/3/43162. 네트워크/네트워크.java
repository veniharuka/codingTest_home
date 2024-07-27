class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                backtrack(computers, visited, i);
            }
        }
        
        return answer;
    }
    
    public void backtrack(int[][] computers, boolean[] visited, int n) {
        visited[n] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[n][i] == 1) { 
                backtrack(computers, visited, i); 
            }
        }
    }
}
