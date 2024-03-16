import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,l;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new int[n+2];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for (int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n+1] = l;
        Arrays.sort(arr);

        int left = 1, right = l-1;
        while (left <= right){
            int mid = (left+right)/2;
            int count  = 0;
            for (int i = 1; i<n+2; i++){
                count += (arr[i]-arr[i-1]-1)/mid;
            }
            if (count > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
