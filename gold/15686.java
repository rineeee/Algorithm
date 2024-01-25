import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.*;

public class Main {
    static int min = 4;
    static boolean[] visited;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int n,m;
    static int result = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1){
                    home.add(new int[]{i,j});
                }
                if (tmp == 2){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(result);
    }
    static void dfs(int curr, int num){
        if (num == m){
            ArrayList<int[]> chicken_list = new ArrayList<>();
            for (int i =0; i<chicken.size(); i++) {
                if (visited[i]) {
                    chicken_list.add(chicken.get(i));
                }
            }
            int tmp = 0;
            for (int[] h : home){
                int min_ = Integer.MAX_VALUE;
                for (int[] c : chicken_list){
                    min_ = Math.min(min_, Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]));
                }
                tmp += min_;
            }
            result = Math.min(tmp, result);
            return;
        }

        for (int i = curr; i< chicken.size(); i++){
            visited[i] = true;
            dfs(i + 1, num+1);
            visited[i] = false;
        }
    }
}
