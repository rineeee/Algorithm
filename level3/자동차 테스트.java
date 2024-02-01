import java.io.*;
import java.util.*;

public class Main {
    static int n,q;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            int m = Integer.parseInt(br.readLine());
            int ans = 0;
            int index = Arrays.binarySearch(arr, m);
            if (index >= 0) {
                ans = index * (n - index - 1);
            }
            System.out.println(ans);
        }
    }
}
