import java.util.*;

class Solution {
    List<Integer>[] list;
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        list = new ArrayList[n + 1]; 
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = edge_list[i][0];
            int b = edge_list[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        int dp[][] = new int[k][n+1];
        for (int i=0; i<k; i++){
            Arrays.fill(dp[i], 10001);
        }
        dp[0][gps_log[0]] = 0;
        
        for (int i=0; i<k-1; i++){
            for (int j=1; j<n+1; j++){
                if (dp[i][j] == 10001) continue;
                for (Integer next : list[j]){
                    int tmp = 0;
                    if(gps_log[i+1]!=next) tmp=1;
                    dp[i+1][next] = Math.min(dp[i+1][next], dp[i][j]+tmp);
                }
            }
        }
        int answer = dp[k-1][gps_log[k-1]];
        return answer == 10001 ? -1 : answer;
    }
}
