import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] password;
    static int L;
    static int C;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        check = new boolean[C];
        password = new char[C];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            password[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(password);

        backtracking(0, 0, "");

        System.out.println(sb);

    }

    static void backtracking(int start, int depth, String what) {
        if (depth == L) {
            boolean v_flag = false;
            int c_flag = 0;
            char[] characters = what.toCharArray();
            for (char c : characters) {
                if (c != ' ') {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        v_flag = true;
                    } else {
                        c_flag++;
                    }
                }
            }

            if (v_flag && c_flag >= 2) {
                sb.append(what).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!check[i]) {
                check[i] = true;
                backtracking(i + 1, depth + 1, what + password[i]);
                check[i] = false;
            }
        }

    }
}