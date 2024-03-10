import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer>h = new HashMap<String, Integer>();
        for(String [] c: clothes) {
        	h.put(c[1], h.getOrDefault(c[1], 0)+1);
        }
        
        for(int cnt : h.values()) {
        	answer*=(cnt+1);
        }
        
        return answer-1;
    }
}