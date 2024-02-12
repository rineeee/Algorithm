import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main {
    static int n;
    static boolean[] prime; // false is prime
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        initPrime();
        int start=0, end=0;
        int sum=0;
        int answer=0;
        while (end < list.size()){
            sum += list.get(end);
            while (start<list.size()-1 && sum > n){
                sum -= list.get(start);
                start += 1;
            }
            if (sum == n){
                answer += 1;
            }
            end += 1;
        }
        System.out.println(answer);
    }

    public static void initPrime(){
        prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;

        for (int i=2; i*i<=n; i++){
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i=0; i<=n; i++){
            if (!prime[i]) list.add(i);
        }
    }
}
