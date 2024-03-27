import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0; // 연결하는 최대 갯수
        int dp[] = new int[n];
        int info[][] = new int[n][2];

        for (int idx = 0; idx < n; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a,b 입력
            info[idx][0] = a;
            info[idx][1] = b;
        }

        Arrays.sort(info, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }

        });

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
               if(info[j][1]<info[i][1])
            	   temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp+1;
        }

        for (int i = 0; i < n; i++) cnt = Math.max(cnt, dp[i]);

        System.out.println(n - cnt);

    }
}