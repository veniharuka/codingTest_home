import java.util.*; 

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        while (!queue.isEmpty()) {
            int current = queue.remove();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.remove();
                count++;
            }
            counts.add(count);
        }

        int[] answer = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            answer[i] = counts.get(i);
        }
        return answer;
    }
}