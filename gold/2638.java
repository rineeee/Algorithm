import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int answer = 0;
    public static int[][] map;
    public static boolean[][] outerAirCheck;
    public static Queue<Node> cheezeQ = new LinkedList<>();
    public static Queue<Node> newQ = new LinkedList<>();
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        outerAirCheck = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    cheezeQ.add(new Node(i, j));
                }
            }
        }

        if(cheezeQ.isEmpty()) {
            System.out.println(answer);
            return ;
        }

        simulate();
        System.out.println(answer);
    }

    public static void simulate() {

        while(true) {

            newQ.clear();
            BFS_Set_Air(); 
            while(!cheezeQ.isEmpty()) {
                Node temp = cheezeQ.poll();
                int r = temp.r;
                int c = temp.c;
                int meltingCnt = 0;

                for(int dir=0;dir<4;dir++) {
                    int nr = r + dx[dir];
                    int nc = c + dy[dir];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; 
                    if(map[nr][nc] == 1) continue; 
                    if( map[nr][nc] == 0 && outerAirCheck[nr][nc] == true) { 
                        meltingCnt += 1;
                    }

                }
                if(meltingCnt >= 2) {

                }else if(meltingCnt < 2){
                    newQ.add(new Node(r, c));
                }
            }

            answer += 1;

            if(!newQ.isEmpty()) { 
                cheezeQ.clear();
                for(int i=0;i<N;i++) {
                    for(int j=0;j<M;j++) {
                        map[i][j] = 0;
                    }
                }

                while(!newQ.isEmpty()) {
                    Node temp = newQ.poll();
                    map[temp.r][temp.c]= 1; 
                    cheezeQ.add(new Node(temp.r, temp.c)); 
                }

            }else {
                break;
            }


        }



    }

    public static void BFS_Set_Air() {
        Queue<Node> q = new LinkedList<Node>();
        outerAirCheck = new boolean[N][M];
        outerAirCheck[0][0] = true;
        q.offer(new Node(0,0));
        while(!q.isEmpty()) {
            Node temp = q.poll();
            int r = temp.r;
            int c = temp.c;
            for(int dir=0;dir<4;dir++) {
                int nr = r + dx[dir];
                int nc = c + dy[dir];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(map[nr][nc] == 1) continue;
                if(outerAirCheck[nr][nc] == true) continue;
                outerAirCheck[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
    }

}

class Node{
    int r;
    int c;
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
