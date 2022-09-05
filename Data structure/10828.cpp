/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main(void){
    stack<int> stack;

    int n;
    cin >> n;

    string str;
    for(int i=0; i<n; i++){
        cin >> str;

        if(str == "push"){
            cin >> n;
            stack.push(n);
        }else if(str == "pop"){
            if(!stack.empty()){
                cout << stack.top() << endl;
                stack.pop();
            }else{
                cout << "-1" << endl;
            }
            
        }
    }


    return 0;
}