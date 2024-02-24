import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static HashMap<String, String> parent; 
    public static HashMap<String, Integer> groupSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int f = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            groupSize = new HashMap<>();

            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!parent.containsKey(a)) {
                    parent.put(a, a);
                    groupSize.put(a, 1);
                }
                if (!parent.containsKey(b)) {
                    parent.put(b, b);
                    groupSize.put(b, 1);
                }
                union(a, b);
            }
        }
    }

    public static String find(String x) {
        if (x.equals(parent.get(x))) return x;
        String root = find(parent.get(x));
        parent.put(x, root); 
        return root;
    }

    public static void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA); 
            int updatedSize = groupSize.get(rootA) + groupSize.get(rootB);
            groupSize.put(rootA, updatedSize);
            System.out.println(updatedSize);
        } else {
            System.out.println(groupSize.get(rootA));
        }
    }
}
