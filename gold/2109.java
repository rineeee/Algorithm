import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static class Node implements Comparable<Node>{
        int p, d;
        public Node(int p, int d){
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.p == o.p){
                return o.d - this.d;
            }
            return o.p - this.p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int max = 0;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            max = Math.max(max, d);
            pq.add(new Node(p,d));
        }
        boolean[] checked = new boolean[max+1];
        int result = 0;
        while (!pq.isEmpty()){
            Node curr = pq.poll();
            for (int i = curr.d; i>0; i--){
                if (!checked[i]){
                    checked[i] = true;
                    result += curr.p;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
