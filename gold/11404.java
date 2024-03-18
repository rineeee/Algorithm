import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int INF = 987654321;

        int[][] answer = new int[n+1][n+1];
        for (int i=0; i<n+1; i++){
            Arrays.fill(answer[i], INF);
            answer[i][i] = 0;
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            answer[a][b] = Math.min(answer[a][b], c);
        }
        for (int k=1; k<n+1; k++){
            for (int i=1; i<n+1; i++){
                for (int j=1; j<n+1; j++){
                    answer[i][j] = Math.min(answer[i][j], answer[i][k]+answer[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(answer[i][j] == INF) {
                    sb.append("0 ");
                }
                else sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
