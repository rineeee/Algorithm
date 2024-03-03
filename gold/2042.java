import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   
        int M = Integer.parseInt(st.nextToken());   
        int K = Integer.parseInt(st.nextToken());   
        arr = new long[N];
        tree = new long[4 * N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0, arr.length - 1, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {  
                long diff = c - arr[b - 1];
                update(0, arr.length - 1, 1, b - 1, diff);
            } else if (a == 2) { 
                bw.write(sum(0, arr.length - 1, 1, b - 1, c - 1) + "\n");
            } else {
                return;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
        }
    }

    static long sum(int start, int end, int node, int left, long right) {
        if (left > end || right < start) { 
            return 0;
        }
        if (left <= start && end <= right) { 
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) {
            return;
        }
        tree[node] += diff;
        if (start == end) {
            arr[index] = tree[node]; 
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }
}
