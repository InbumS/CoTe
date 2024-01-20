

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= num; i++) {
            int size = Integer.parseInt(bf.readLine());
            int[][] arr = new int[size][size];

            for (int j = 0; j < size; j++) {
                String a = bf.readLine();
                for (int k = 0; k < size; k++) {
                    arr[j][k] = a.charAt(k) - '0';
                }
            }

            int result = 0;
            int mid = size / 2;
            int left = mid;
            int right = mid;

            for (int j = 0; j < size; j++) {
                for (int k = left; k <= right; k++) {
                    result += arr[j][k];
                }

                if (j < mid) {
                    left -= 1;
                    right += 1;
                } else {
                    left += 1;
                    right -= 1;
                }
            }

            // 출력 부분을 반복문 밖으로 이동
            System.out.printf("#%d %d\n", i, result);
        }
    }
}
