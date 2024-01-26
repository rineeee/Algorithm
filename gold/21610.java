import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.*;

public class Main {
    public static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[] dx = new int[]{0,-1,-1,-1,0,1,1,1};
    static int[] dy = new int[]{-1,-1,0,1,1,1,0,-1};
    static boolean[][] visited;
    static Queue<Cloud> clouds = new LinkedList<>();
    static int n,m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        clouds.add(new Cloud(n - 1, 0));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 2, 0));
        clouds.add(new Cloud(n - 2, 1));
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            solve(d-1,s);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    static void solve(int d, int s){
        for (Cloud cloud : clouds){
            cloud.x = (n + cloud.x + dx[d] * (s % n)) % n;
            cloud.y = (n + cloud.y + dy[d] * (s % n)) % n;
            map[cloud.x][cloud.y] ++;
        }

        while (!clouds.isEmpty()){
            Cloud cloud = clouds.poll();
            int cnt = 0;
            visited[cloud.x][cloud.y] = true;
            for (int i = 1; i < 8; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] >= 1)
                        cnt++;
                }
            }
            map[cloud.x][cloud.y] += cnt;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        visited = new boolean[n][n];
    }
}
