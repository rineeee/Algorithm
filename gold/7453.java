import javax.xml.transform.SourceLocator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
 
public class Main {
 
    static int n;
    static long result;
    static int [][]arr;
    static int [] AB;
    static int [] CD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
 
        arr = new int[4][n];
 
        AB = new int[n*n];
        CD = new int[n*n];
 
        for(int j=0; j<n; j++){
            String[] s = br.readLine().split(" ");
            for(int i=0; i<4; i++){
                arr[i][j] = Integer.parseInt(s[i]);
            }
        }
 
        int k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                AB[k++]=arr[0][i]+arr[1][j];
            }
        }
 
        k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                CD[k++]=arr[2][i]+arr[3][j];
            }
        }
 
 
        Arrays.sort(AB);
        Arrays.sort(CD);
 
        solve();
 
        System.out.println(result);
 
    }
 
    private static void solve(){
        int left=0;
        int right = n*n-1;
 
        while(left<n*n && right>=0){
            long num1 = AB[left];
            long num2 = CD[right];
            long sum = num1+num2;
            if(sum<0){
                left++;
            }
            else if(sum>0) {
                right--;
            }
            else{
                long temp1=0;
                long temp2=0;
                while(left<n*n && num1==AB[left]){
                    left++;
                    temp1++;
                }
                while(right>=0 && num2==CD[right]){
                    right--;
                    temp2++;
                }
                result+=temp1*temp2;
            }
        }
    }
}
