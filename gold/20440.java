import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> mosEnterExit = new HashMap<>();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mosEnterExit.put(a, mosEnterExit.getOrDefault(a, 0) + 1);
            mosEnterExit.put(b, mosEnterExit.getOrDefault(b, 0) - 1);
        }
        int maxMosCount = -1;
        int startTime = -1;
        int endTime = -1;

        // 최대값 구간이 2개 이상일 때를 대비한 체크 변수
        boolean check = false;

        // 시간 순서대로 탐색
        ArrayList<Integer> times = new ArrayList<>(mosEnterExit.keySet());
        Collections.sort(times);

        int sumMos = 0;

        for (int time : times) {
            sumMos += mosEnterExit.get(time);

            if (sumMos > maxMosCount) {
                maxMosCount = sumMos;
                startTime = time;
                check = true;
            } else if (sumMos < maxMosCount && check) {
                endTime = time;
                check = false;
            }
        }

        System.out.println(maxMosCount);
        System.out.println(startTime + " " + (check ? "?" : endTime));
    }
}
