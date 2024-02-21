import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [][] exp;
    static int [] perm;
    static int N;
    static int [] temp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        exp = new int[N][9];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                exp[i][j] = Integer.parseInt(st.nextToken());
            }}
        //// 입출력 ////
        int maxNum = 0;
        perm = new int[]{0,1,2,3,4,5,6,7,8};
        // 순열 시작 //
        do {
        	temp = perm.clone();
        	int thisNum = 0;
        	// 인덱스 0번 (1번 선수 고정)
        	int fixNum = perm[0];
        	for(int i=1; i<=3; i++) {temp[i-1] = temp[i];}
        	temp[3] = fixNum;
        	// 점수 검사
        	thisNum = howScore();
        	maxNum = Math.max(maxNum, thisNum); 
        	
        }
        while(next_permutation());
	    System.out.println(maxNum);
}
    
    // Next Permutation 
    // 0번째 인덱스를 빼고 넥퍼 
	static boolean next_permutation() {
		int N = perm.length;
	    int i=N-1;
	    while(i>1 && perm[i-1] >= perm[i])--i;
	    if(i==1) return false;
	    
	    int j=N-1;
	    while(perm[i-1]>=perm[j])--j;
	    
	    int tmp = perm[i-1];
	    perm[i-1] = perm[j];
	    perm[j] = tmp;
	    
	    int k=N-1;
	    while (i<k) {
	        tmp = perm[i];
	        perm[i] = perm[k];
	        perm[k] = tmp;
	        ++i; --k;	        
	    }
	    return true;
	}
	
	
	// 점수 구하는 함수
	static int howScore() {
		int num = 0;
		int idx = 0;
		boolean[] base = new boolean [4];
		for(int inning=0; inning<N; inning++) {
			int out =3;
			Arrays.fill(base, false);
			while(out>0) {
				if(exp[inning][temp[idx]]==0) {
					out--;
				}
				else {
					switch(exp[inning][temp[idx]]) {
					case 1:
						if(base[2]==true) {
							base[2] = false;
							num++;
						}
						for(int k=1; k>=0; k--) {
							if(base[k]==true) {
								base[k+1] = true;
								base[k]=false;
							}
						}
						base[0]=true;
						break;
						
						
					case 2:
						if(base[1]==true) {
							base[1]=false;
							num++;
						}
						if(base[2]==true) {
							base[2]= false;
							num++;
						}
						if(base[0]==true) {
							base[0]=false;
							base[2]=true;
							
						}base[1]=true;
						break;
						
						
					case 3:
						for(int k=0; k<3; k++) {
							if(base[k]==true) {
								num++;
								base[k]= false;
							}
						}
						base[2]=true;
						break;
						
					case 4:
						for(int k=0; k<3; k++) {
							if(base[k]==true) {
								num++;
								base[k]= false;
							}
						}
						num++;
						break;
					
					}
				}
				idx = (idx+1)%9;
				
			}
		}
		return num;
	}
}