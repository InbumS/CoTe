import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int answer;
    static int[][] map = new int[10][10];
    static List<APInfo> APList;
    static Phone user1;
    static Phone user2;
    // 이동 방향 : 0이면 이동 불가
    static int[] UP = {-1, 0};
    static int[] RIGHT = {0, 1};
    static int[] DOWN = {1, 0};
    static int[] LEFT = {0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= T; idx++) {
            answer = 0; // 정답
            int nowIdx = 0; // 현재 시행 횟수
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 이동 정보
            int A = Integer.parseInt(st.nextToken()); // 충전소 갯수
            int[] moveA = new int[M]; //(0,0)에서 시작하는 이동 정보
            int[] moveB = new int[M]; //(9,9)에서 시작하는 이동 정보
            st = new StringTokenizer(br.readLine());
            for (int t = 0; t < M; t++) moveA[t] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int t = 0; t < M; t++) moveB[t] = Integer.parseInt(st.nextToken());
            APList = new ArrayList<>(); // 충전소 저장 배열 선언
            for (int t = 0; t < A; t++) {
                st = new StringTokenizer(br.readLine());
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                int a3 = Integer.parseInt(st.nextToken());
                int a4 = Integer.parseInt(st.nextToken());
                APList.add(new APInfo(a1 - 1, a2 - 1, a3, a4)); // 배열에다 하나 씩 AP 정보 저장
            }
            // 초기 사용자 세팅
            user1 = new Phone(0, 0, 0);
            user2 = new Phone(9, 9, 0);

            // M번 돌면서
            while (M > -1) {
                // 연결이 가능한지
                PossibleCharge(user1, user2);
//                System.out.println("유저1 정답:" + "idx" + nowIdx + "는" + (user1.nowEnergy+user2.nowEnergy));
//                System.out.println("유저2 정답:"+ "idx"+nowIdx+"는"+ user2.nowEnergy);
                if(nowIdx == moveB.length) {
                    break;
                }
                update(user1, moveA[nowIdx]);
                update(user2, moveB[nowIdx]);
                // 인덱스 증가
                nowIdx++;
                M--;

            }

            // 두 개의 합
            answer = user1.nowEnergy + user2.nowEnergy;
            System.out.println("#" + idx + " " + answer);
        }
    }

    // 위치 갱신
    static void update(Phone p, int num) {
        switch (num) {
            case 0:
                break;
            case 1:
                p.y += UP[0];
                p.x += UP[1];
                break;
            case 2:
                p.y += RIGHT[0];
                p.x += RIGHT[1];
                break;
            case 3:
                p.y += DOWN[0];
                p.x += DOWN[1];
                break;
            case 4:
                p.y += LEFT[0];
                p.x += LEFT[1];
                break;
        }
    }

    static void PossibleCharge(Phone p1, Phone p2) {
        boolean flag1 = false, flag2 = false; // true면 계산 처리 함수 보낸다.
        List<Integer>[] what = new ArrayList[2]; //배열 선언으로 필요 한 것만 넣는다.
        what[0] = new ArrayList<>();
        what[1] = new ArrayList<>(); // 배열 초기화

        // AP배열 사이즈 만큼 가능한지 체킹
        for (int i = 0; i < APList.size(); i++) {
            if (Math.abs(p1.x - APList.get(i).x) + Math.abs(p1.y - APList.get(i).y) <= APList.get(i).coverage) {
                flag1 = true;
                what[0].add(i);
            }
            if (Math.abs(p2.x - APList.get(i).x) + Math.abs(p2.y - APList.get(i).y) <= APList.get(i).coverage) {
                flag2 = true;
                what[1].add(i);
            }
        }
        if (flag1 && flag2) RecordShareScore(what);
            // 어떤 것을 점수 매길 건지
        else if (flag1 && !flag2) RecordOneScore(p1, what[0]);
        else if (flag2 && !flag1) RecordOneScore(p2, what[1]);


    }

    // 둘 다 만났을 때인데 여기서 겹칠 때도 체크 해준다.
    static void RecordShareScore(List<Integer>[] what) {
        int max1 = 0, max2 = 0;
        for (int i = 0; i < what[0].size(); i++) {
            for (int j = 0; j < what[1].size(); j++) {
                // what 0과 what 1과
                int idx1 = what[0].get(i);
                int idx2 = what[1].get(j);
                int produce1 = APList.get(idx1).produce;
                int produce2 = APList.get(idx2).produce;
                if (idx1 == idx2 && max1 + max2 < produce1) { // 두 사용자가 같은 충전소에 접속한 경우
                    // 충전량을 반으로 나눠줌
                    max1 = produce1 / 2;
                    max2 = produce2 / 2;
                } else if (idx1 != idx2 && max1 + max2 < produce1 + produce2) {
                    max1 = produce1;
                    max2 = produce2;
                }
            }
        }
        user1.nowEnergy += max1;
        user2.nowEnergy += max2;
    }

    // 한개의 점수만 넣는다..
    static void RecordOneScore(Phone p, List<Integer> choose) {
        int max = 0;
        for (int i = 0; i < choose.size(); i++) {
            max = Math.max(max, APList.get(choose.get(i)).produce);
        }

        p.nowEnergy += max;
    }

    // 휴대폰 위치 및 충전량 정보
    static class Phone {
        int x;
        int y;
        int nowEnergy;

        public Phone(int x, int y, int nowEnergy) {
            super();
            this.x = x;
            this.y = y;
            this.nowEnergy = nowEnergy;
        }
    }

    // 충전소 정보를 담은 클래스
    static class APInfo {
        int x;
        int y;
        int coverage;
        int produce;

        public APInfo(int x, int y, int coverage, int produce) {
            super();
            this.x = x;
            this.y = y;
            this.coverage = coverage;
            this.produce = produce;
        }
    }
}