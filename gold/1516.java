import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int[] indegree;
    public static int[] time;
    public static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        indegree = new int[n+1];
        time = new int[n+1];
        list = new ArrayList[n+1];
        for (int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true){
                int curr = Integer.parseInt(st.nextToken());
                if (curr == -1){
                    break;
                }
                indegree[i] ++;
                list[curr].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n+1];
        for (int i=1; i<=n; i++){
            if (indegree[i] == 0){
                q.add(i);
                result[i] = time[i];
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int i: list[curr]){
                indegree[i] --;
                result[i] = Math.max(result[i], result[curr] + time[i]);
                if (indegree[i] == 0){
                    q.add(i);
                }
            }
        }

        for (int i=1; i<=n; i++){
            System.out.println(result[i]);
        }

    }
}
