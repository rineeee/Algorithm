import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arr = new int[n][m];
        boolean[][] visited;
        StringTokenizer st;
        int left = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 1) left++;
            }
        }
        int time = 0;
        int lastCheese = 0;
        while (left != 0) {
            time ++;
            lastCheese = left;
            visited = new boolean[n][m];
            visited[0][0] = true;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] prev = q.poll();
                int x = prev[0], y = prev[1];
                for (int i=0; i<4; i++){
                    int nx = x+dx[i], ny = y+dy[i];
                    if (0<=nx && nx<n && 0<=ny && ny<m && !visited[nx][ny]){
                        visited[nx][ny]=true;
                        if(arr[nx][ny] == 0){
                            q.add(new int[]{nx, ny});
                        }else{
                            left --;
                            arr[nx][ny] = 0;
                        }
                    }
                }

            }
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }
}
