class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int plusum = 0;
        int multisum=1;
        for(int i=0; i<num_list.length; i++){
            plusum= plusum+num_list[i];
            multisum =multisum* num_list[i];
            
        }
        if(plusum*plusum >multisum){
            answer=1;
        }else{
            answer=0;
        }
        return answer;
    }
}