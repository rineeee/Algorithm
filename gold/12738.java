import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for(int i = 0 ; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        list.add(Integer.MIN_VALUE);

        for(int i = 0 ; i < n; i++){
            int num = arr[i];
            int left = 0;
            int right = list.size() - 1;

            if(num > list.get(list.size() - 1)) list.add(num);
            else{
                while(left < right){
                    int mid = (left + right) /2;
                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        System.out.println(list.size()-1);

    }

}
