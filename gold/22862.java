import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        boolean[] arr = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0){
                arr[i] = true;
            }
        }
        int start = 0;
        int end = 0;
        int cnt = 0;
        int answer = 0;
        while (end < n){
            if (cnt < k){
                if (!arr[end]){
                    cnt ++;
                }
                end ++;
                answer = Math.max(answer, end-start-cnt);
            }else if (arr[end]){
                end ++;
                answer = Math.max(answer, end-start-cnt);
            }else{
                if (!arr[start]){
                    cnt --;
                }
                start ++;
            }
        }
        System.out.println(answer);
    }
}
