
import java.io.*;
import java.util.*;

public class Solution {
            public static void main(String[] args) throws IOException {

                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(bf.readLine());

                for(int i=1; i<=num;i++){
                    int cnt=0;
                    String s = bf.readLine();
                    // String length는 함수 처리
                    int [] arr = new int[s.length()];
                    for(int j=0; j<arr.length; j++){
                        //int 처리
                        arr[j] = s.charAt(j)-'0';
                    }

                    if(arr[0]==1)
                        cnt+=1;

                    for(int j=0; j<arr.length-1; j++){
                        if(arr[j]!=arr[j+1])
                            cnt+=1;
                    }

                    System.out.printf("#%d %d\n",i,cnt);
                }



                }

            }
