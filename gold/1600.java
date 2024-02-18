import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int k, w, h;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0,k));
        visited[0][0][k] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();
            if (curr.x==h-1 && curr.y==w-1){
                return curr.cnt;
            }
            for (int i=0; i<4; i++){
                int nx = curr.x+dx[i], ny=curr.y+dy[i];
                if (0<=nx && nx<h && 0<=ny && ny<w && !visited[nx][ny][curr.k] && map[nx][ny] ==0){
                    q.add(new Node(nx,ny,curr.cnt+1, curr.k));
                    visited[nx][ny][curr.k] = true;
                }
            }
            if (curr.k > 0){
                for (int i=0; i<8; i++){
                    int nx = curr.x+hdx[i], ny=curr.y+hdy[i];
                    if (0<=nx && nx<h && 0<=ny && ny<w && !visited[nx][ny][curr.k-1] && map[nx][ny] ==0){
                        q.add(new Node(nx,ny,curr.cnt+1, curr.k-1));
                        visited[nx][ny][curr.k-1] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static class Node{
        int x,y,cnt,k;
        public Node(int x, int y, int cnt, int k){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }
}
