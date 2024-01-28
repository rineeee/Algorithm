import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Fireball {
        int r,c,m,s,d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
    static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};;
    static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Fireball>[][] map;
    static ArrayList<Fireball> fireballs = new ArrayList<>();
    static int n,m,k;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r,c,m,s,d));
        }
        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                map[i][j] = new ArrayList<>();
        }

        while(k-- > 0){
            move();
            action();
        }
        int answer = 0;
        for (Fireball f: fireballs){
            answer += f.m;
        }
        System.out.println(answer);
    }

    static void move() {
        for (Fireball f: fireballs){
            f.r = (n+f.r+dr[f.d]*(f.s%n))%n;
            f.c = (n+f.c+dc[f.d]*(f.s%n))%n;
            map[f.r][f.c].add(f);
        }
    }

    static void action() {
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j].size() >=2){
                    int m_sum=0, s_sum=0, odd =0, even = 0;
                    int size = map[i][j].size();

                    for (Fireball f: map[i][j]){
                        m_sum += f.m;
                        s_sum += f.s;
                        if((f.d % 2) == 1){
                            odd++;
                        }else{
                            even++;
                        }
                        fireballs.remove(f);
                    }
                    map[i][j].clear();
                    m_sum /= 5;
                    if (m_sum==0){
                        continue;
                    }
                    s_sum /= size;
                    if(odd==size || even==size){
                        for (int k=0; k<8; k+=2){
                            fireballs.add(new Fireball(i,j,m_sum,s_sum,k));
                        }
                    }else{
                        for (int k=1; k<8; k+=2){
                            fireballs.add(new Fireball(i,j,m_sum,s_sum,k));
                        }
                    }

                } else {
                    map[i][j].clear();
                }
            }
        }
    }
}
