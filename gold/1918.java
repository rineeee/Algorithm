import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String n;
    public static int priority(char temp){
        if(temp == '(') return 0;
        else if(temp == '+' || temp == '-') return 1;
        else return 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n.length(); i++){
            char curr = n.charAt(i);
            if (curr == '('){
                stack.add(curr);
            } else if (curr == ')') {
                while (!stack.isEmpty()){
                    char prev = stack.pop();
                    if (prev == '(') break;
                    System.out.print(prev);
                }
            } else if ('A' <= curr && curr <= 'Z') {
                System.out.print(curr);
            } else{
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(curr)){
                    System.out.print(stack.pop());
                }
                stack.add(curr);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        
    }
}
