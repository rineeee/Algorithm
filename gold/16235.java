import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Tree implements Comparable<Tree>{
       int x,y,z;
        public Tree(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Tree o){
            return this.z - o.z;
        }
    }

    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};;
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] plus;
    static int[][] map;
    static Deque<Tree> treeList = new LinkedList<>();
    static int n,m,k;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        plus = new int[n][n];
        map = new int[n][n];
        for (int i =0; i<n; i++){
            Arrays.fill(map[i], 5);
        }

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                plus[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            treeList.add(new Tree(x,y,z));
        }

        while(k-- >0){
            action();
        }
        System.out.println(treeList.size());
    }

    static public void action(){
        Queue<Tree> dead = new LinkedList<>();
        for (int i = 0; i < treeList.size();) {
            Tree t = treeList.poll();
            if (map[t.x][t.y] >= t.z){
                map[t.x][t.y] -= t.z;
                t.z++;
                i++;
                treeList.add(t);
             } else{
                dead.add(t);
            }
        }

        for (Tree t: dead){
            map[t.x][t.y] += t.z/2;
        }

        Queue<Tree> temp_list = new LinkedList<>();
        for (Tree t : treeList) {
            if (t.z % 5 == 0) {
                temp_list.add(t);
            }
        }
        while (!temp_list.isEmpty()) {
            Tree t = temp_list.poll();

            for (int i = 0; i < 8; i++) {
                int next_x = t.x + dx[i];
                int next_y = t.y + dy[i];
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n) {
                    treeList.addFirst(new Tree(next_x, next_y, 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += plus[i][j];
            }
        }

    }
}
