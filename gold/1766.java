import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[] indegree;
    public static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n+1];
        list = new ArrayList[n+1];
        for (int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b] ++;
            list[a].add(b);
        }

        Queue<Integer> q = new PriorityQueue<>();
        for (int i=1; i<=n; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int i: list[curr]){
                indegree[i] --;
                if (indegree[i] == 0){
                    q.add(i);
                }
            }
            System.out.print(curr+" ");
        }
    }
}
