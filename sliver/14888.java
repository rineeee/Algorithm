import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] number;
    static int min;
    static int max;
    static int[] operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        operator = new int[4];
        min = Integer.MAX_VALUE;
        max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int num,int idx){
        if (idx == n){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int op=0; op<4; op++){
            if (operator[op] > 0){
                operator[op]--;
                switch (op) {
                    case 0: dfs(num + number[idx], idx + 1);   break;
                    case 1:	dfs(num - number[idx], idx + 1);   break;
                    case 2:	dfs(num * number[idx], idx + 1);   break;
                    case 3: dfs(num / number[idx], idx + 1);   break;
                }
                operator[op] ++;
            }
        }
    }
}
