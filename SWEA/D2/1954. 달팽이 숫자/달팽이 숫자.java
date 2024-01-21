

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    // 우 하 좌 상
    static int dx [] ={1,0,-1,0};
    static int dy [] ={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        for(int i=1; i<=num; i++){
            System.out.println("#"+i);
            int target = Integer.parseInt(bf.readLine());
            int [][] arr = new int [target][target];
            int start = 1;
            int x =0,y = 0, status = 0;
            while (start<= target*target){
                if(x>=0 && x < target && 0<=y && y < target && arr[x][y]==0){
                    arr[x][y] = start;
                    start+=1;

                }

                else{
                    // index가 넘은 것에 대한 원상 복구
                    x-=dx[status];
                    y-=dy[status];
                    status = (status+1)%4;
                }

                x+=dx[status];
                y+=dy[status];


            }
            for(int row=0; row<target; row++) {
                for (int col = 0; col < target; col++) {
                    System.out.print(arr[col][row]+" ");
                }
                System.out.println();
            }

        }
    }
}
