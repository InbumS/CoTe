import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    public static StringTokenizer st;
    public static StringBuilder sb;
    public static int[] checkList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        checkList = new int[4];
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int total = 0;
        boolean flag = false;
        String dna = br.readLine();
        int[] checkArray = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++) {
            char currentChar = dna.charAt(i);
            if (currentChar == 'A') checkArray[0]++;
            else if (currentChar == 'C') checkArray[1]++;
            else if (currentChar == 'G') checkArray[2]++;
            else if (currentChar == 'T') checkArray[3]++;
        }

        for (int i = 0; i < 4; i++) {
            if (checkList[i] > checkArray[i])
                flag = true;
        }
        if (!flag) total++;
       
        
        for (int i = t; i < s; i++) {
            char removedChar = dna.charAt(i - t);
            if (removedChar == 'A') checkArray[0]--;
            else if (removedChar == 'C') checkArray[1]--;
            else if (removedChar == 'G') checkArray[2]--;
            else if (removedChar == 'T') checkArray[3]--;

            char addedChar = dna.charAt(i);
            if (addedChar == 'A') checkArray[0]++;
            else if (addedChar == 'C') checkArray[1]++;
            else if (addedChar == 'G') checkArray[2]++;
            else if (addedChar == 'T') checkArray[3]++;

            flag = false;

            //System.out.println(Arrays.toString(checkArray));
            for (int j = 0; j < 4; j++) {
                if (checkList[j] > checkArray[j])
                    flag = true;
            }
            if (!flag) total++;
        }
        

        System.out.println(total);
    }
}