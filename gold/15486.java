import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+2];
        int[] p = new int[n+2];
        int[] dp = new int[n+2];

        StringTokenizer st;
        for (int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for (int i=1; i<=n+1; i++){
            if (max < dp[i]){
                max = dp[i];
            }
            int next = i+t[i];
            if (next < n+2){
                dp[next] = Math.max(dp[next], max+p[i]);
            }
        }
        System.out.println(max);
    }
}
