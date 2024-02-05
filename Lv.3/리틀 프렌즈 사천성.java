import java.util.*;

class Solution {
    char[][] NBoard;
    HashMap<Character, int[][]> hm = new HashMap<>();
    List<Character> list = new ArrayList<>();
    
    public String solution(int m, int n, String[] board) {
        String answer = "";
        NBoard = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char curr = board[i].charAt(j);
                NBoard[i][j] = curr;
                
                if (curr != '.' && curr != '*') {
                    if (!hm.containsKey(curr)) {
                        list.add(curr);
                        hm.put(curr, new int[2][2]);
                        hm.get(curr)[0][0] = i;
                        hm.get(curr)[0][1] = j;
                    } else {
                        hm.get(curr)[1][0] = i;
                        hm.get(curr)[1][1] = j;
                    }
                }
            }   
        }
        
        Collections.sort(list);
        int idx = 0;
        while (list.size() != 0) {
            if (canDelete(list.get(idx))) {
                char popped = list.remove(idx);
                answer += popped;
                deleteChar(popped);
                idx = 0;
            } else {
                idx++;
                if (idx == list.size()) {
                    return "IMPOSSIBLE";
                }       
            }
        }
        
        return answer;
    }
    
    public void deleteChar(char p) {
        int[][] curr = hm.get(p);
        NBoard[curr[0][0]][curr[0][1]] = '.';
        NBoard[curr[1][0]][curr[1][1]] = '.';
    }
    
    boolean canDelete(char a){
        int r1 = hm.get(a)[0][0];
        int c1 = hm.get(a)[0][1];
        int r2 = hm.get(a)[1][0];
        int c2 = hm.get(a)[1][1];
        
        if(c1 < c2){
            if(linearColumnCheck(c1, c2, r1, a) && linearRowCheck(r1, r2, c2, a)){
                return true;
            }
            if(linearRowCheck(r1, r2, c1, a) && linearColumnCheck(c1, c2, r2, a)){
                return true;
                }
        }else{
            if(linearRowCheck(r1, r2, c2, a) && linearColumnCheck(c2, c1, r1, a)){
                return true;
            }
            if(linearColumnCheck(c2, c1, r2, a) && linearRowCheck(r1, r2, c1, a)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean linearRowCheck(int r1, int r2, int c, char a){
        for(int i = r1; i < r2+1; i++){
            if(NBoard[i][c] != '.' && NBoard[i][c] != a)
                return false;
        }
        return true;
    }
    
    boolean linearColumnCheck(int c1, int c2, int r, char a){
        for(int i = c1; i < c2+1; i++){
            if(NBoard[r][i] != '.' && NBoard[r][i] != a)
                return false;
        }
        return true;
    }
}
