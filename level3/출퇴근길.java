import java.io.*;
import java.util.*;

public class Main {
    static int n,m,s,t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> graphR = new ArrayList<>();
        for (int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            graphR.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph.get(a).add(b);
            graphR.get(b).add(a);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken())-1;
        t = Integer.parseInt(st.nextToken())-1;

        boolean[] vTo = new boolean[n];
        vTo[t] = true;
        boolean[] vFrom = new boolean[n];
        vFrom[s] = true;
        boolean[] vRTo = new boolean[n];
        boolean[] vRFrom = new boolean[n];

        dfs(s,vTo,graph);
        dfs(t,vFrom,graph);
        dfs(s,vRTo,graphR);
        dfs(t,vRFrom,graphR);

        int count = 0;
        for (int i=0; i<n; i++){
            if (vTo[i] && vFrom[i] && vRTo[i] && vRFrom[i]){
                count ++;
            }
        }
        System.out.println(count-2);
    }
    static public void dfs(int curr, boolean[] visited, List<List<Integer>> graph){
        if (visited[curr]){
            return;
        }
        visited[curr] = true;
        for (Integer next: graph.get(curr)){
            if (!visited[next]){
                dfs(next, visited, graph);
            }
        }

    }
}
