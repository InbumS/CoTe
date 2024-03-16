class Solution {
    static int answer = 0;
    
    static void dfs(int [] numbers, int target, int total, int idx){
        if(idx == numbers.length && total == target){
            answer +=1;
            return;
        }
            
        else if(idx >= numbers.length) return;
        
        dfs(numbers, target, total+numbers[idx], idx+1);
        dfs(numbers, target, total-numbers[idx], idx+1);
        
        
    }
    
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0 , 0);
        
        
        return answer;
    }
}