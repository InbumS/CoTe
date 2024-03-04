class Solution {
    static int answer = 0;
    public int solution(String skill, String[] skill_trees) {
         	char[] seq = new char[skill.length()];
	        for(int idx = 0; idx<skill.length(); idx++){
	           seq[idx] = skill.charAt(idx);
	        }
	        // 스킬 트리 길이 만큼
	        for(int i=0; i<skill_trees.length; i++) {
	        	boolean flag = true;
	        	for(int j=1; j<seq.length; j++) {
	        		int start = skill_trees[i].indexOf(seq[j-1]);
	        		int end = skill_trees[i].indexOf(seq[j]);
	        		
	        		//끝이 존재하나 시작이 더 큰수 일때!
	        		if(end!=-1 && start>end) {
	        			flag = false;
	        			break;
	        		}
	        		
	        		// 뒤에 것이 먼저 존재할 때
	        		if(start == -1 && end !=-1) {
	        			flag = false;
	        			break;
	        		}
	        		
	        	}
	        	if(flag)answer++;
	        }
	       
	        return answer;
	    }
	
}