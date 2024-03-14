import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        String[] tmp = br.readLine().split(" ");
        for (int i=0; i<n; i++){
             arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(arr);
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                int sum1 = arr[i] + arr[j];
                int start = 0, end = n-1;
                while(start < end){
                    if(start == i || start == j){
                        start ++;
                    }
                    if(end == i || end == j){
                        end --;
                    }
                    int sum2 = arr[start] + arr[end];
                    answer = Math.min(answer, Math.abs(sum1-sum2));
                    if (sum1>sum2){
                        start ++;
                    }else if (sum1<sum2){
                        end --;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
