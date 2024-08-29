import java.util.*;

class Solution {
    int[] dr = { 0, 1, 0, -1 };
    int[] dc = { 1, 0, -1, 0 };
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < answer.length; i++) {
            if (check(places[i])) answer[i] = 1;
        }
        return answer;
    }
    
    boolean check(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
	            	
                if (place[r].charAt(c) == 'P') {
                    if (!dfs(r, c, place, new boolean[5][5], 0)) return false;
                }
            }
        }
        return true;
    }
    
    boolean dfs(int r, int c, String[] place, boolean[][] visited, int depth) {
        if (depth >= 2) return true;

        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (inRange(nr, nc) && place[nr].charAt(nc) != 'X') {
                if (!visited[nr][nc]) {
                    
                    if (place[nr].charAt(nc) == 'P') return false;
                    if (!dfs(nr, nc, place, visited, depth + 1)) return false;
                }
            }
        }
        
        return true;
    }
    
    boolean inRange(int r, int c) {
        return (r >= 0) && (r < 5) && (c >= 0) && (c < 5);
    }
}