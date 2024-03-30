import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,d,k,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken())-1;
        int[] arr = new int[n];
        int[] eaten = new int[d];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine())-1;
        }
        int cnt = 0;
        int result = 0;
        for (int i=0; i<k; i++){
            if (eaten[arr[i]]++ == 0) cnt++;
        }
        for (int i=0; i<n; i++){
            if (result <= cnt){
                if (eaten[c] ==0){
                    result = cnt+1;
                }else{
                    result = cnt;
                }
            }
            int last = (i+k)%n;
            if(eaten[arr[last]]++ == 0) cnt++;
            if(--eaten[arr[i]] == 0) cnt --;
        }
        System.out.println(result);
    }
}
