import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int right = -1;

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int left = 0;
        int answer = 0;

        while (left <= right){
            int mid = (left+right)/2;
            if (check(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int mid){
        int min = arr[0];
        int max = arr[0];
        int cnt = 1;
        for (int i=0; i<n; i++){
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);

            if (max-min > mid){
                cnt ++;
                min = arr[i];
                max = arr[i];
            }
        }

        return cnt <= m;
    }
}
