import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = 4;
    static boolean[][] ladder;
    static int n, m, h;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new boolean[h][n - 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x - 1][y - 1] = true;
        }

        solve(0, 0);

        if (min == 4) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            int curr = i;
            for (int j = 0; j < h; j++) {
                if (curr < n - 1 && ladder[j][curr]) {
                    curr += 1;
                } else if (curr > 0 && ladder[j][curr - 1]) {
                    curr -= 1;
                }
            }
            if (curr != i) {
                return false;
            }
        }
        return true;
    }

    static void solve(int x, int count) {
        if (count > 3 || count >= min) {
            return;
        }

        if (check()) {
            min = Math.min(min, count);
            return;
        }

        for (int i = x; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!ladder[i][j] && (j == 0 || !ladder[i][j - 1]) && (j == n - 2 || !ladder[i][j + 1])) {
                    ladder[i][j] = true;
                    solve(i, count + 1);
                    ladder[i][j] = false;
                }
            }
        }
    }
}
