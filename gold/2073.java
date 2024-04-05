import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] dp = new int[d+1];
        dp[0] = Integer.MAX_VALUE;
        for (int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j=d; j>=l; j--){
                dp[j] = Math.max(dp[j], Math.min(c, dp[j-l]));
            }
        }
        System.out.println(dp[d]);
    }
}
