import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int x, y;
    static int currSize = 2;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int eatenFish = 0;
    static int totalTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp > 0) {
                    if (tmp == 9) {
                        x = i;
                        y = j;
                    } else {
                        arr[i][j] = tmp;
                    }
                }
            }
        }
        while (true) {
            if (!move()) {
                System.out.println(totalTime);
                return;
            }
        }
    }

    public static boolean move() {
        visited = new boolean[n][n];
        Queue<Fish> queue = new PriorityQueue<>();
        queue.offer(new Fish(x, y, 0));
        visited[x][y] = true;
        boolean canMove = false;

        while (!queue.isEmpty()) {
            Fish current = queue.poll();

            if (arr[current.x][current.y] != 0 && arr[current.x][current.y] < currSize) {
                arr[current.x][current.y] = 0;
                x = current.x;
                y = current.y;
                eatenFish++;
                canMove = true;
                totalTime += current.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && arr[nx][ny] <= currSize) {
                    visited[nx][ny] = true;
                    queue.offer(new Fish(nx, ny, current.dist + 1));
                }
            }
        }

        if (!canMove)
            return false;

        if (currSize == eatenFish) {
            currSize++;
            eatenFish = 0;
        }
        return true;
    }

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish other) {
            if (this.dist == other.dist) {
                if (this.x == other.x)
                    return this.y - other.y;
                return this.x - other.x;
            }
            return this.dist - other.dist;
        }
    }
}
