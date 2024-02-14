import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;
    static int now =2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j] && arr[i][j] == 1){
                    dfs(i,j);
                    now += 1;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j] >=2){
                    visited = new boolean[n][n];
                    answer = Math.min(answer, bfs(i,j));
                }
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int i, int j){
        arr[i][j] = now;
        visited[i][j] = true;

        for (int k=0; k<4; k++){
            int nx = i+dx[k], ny = j+dy[k];
            if (0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && arr[nx][ny] == 1){
                dfs(nx,ny);
            }
        }
    }
    public static int bfs(int x, int y){
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        int landNum = arr[x][y];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1], cnt = curr[2];
            for (int k=0; k<4; k++){
                int nx = cx+dx[k], ny = cy+dy[k];
                if (0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && arr[nx][ny] != landNum){
                    if (arr[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny,cnt+1});
                    } else {
                        return cnt;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
