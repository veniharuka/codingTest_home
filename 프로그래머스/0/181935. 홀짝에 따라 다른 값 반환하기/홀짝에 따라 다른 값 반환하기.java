class Solution {
    public int solution(int n) {
        int answer = 0;
        
    
        if(n%2==1){
            for(int i=1; i<n+1; i+=2){
                answer=answer+i;
            }
        }
        else{
            for(int j=2; j<n+1; j+=2){
                answer=answer+(j*j);            }
        }
      
        return answer;
    }
}