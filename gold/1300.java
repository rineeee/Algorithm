import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int ans = 0;
        int left = 1, right = k;
        while (left <= right){
            int mid = (left+right)/2;
            int curr = 0;
            for (int i =1; i<=n; i++){
                curr += Math.min(n, mid/i);
            }
            if (k <= curr){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
