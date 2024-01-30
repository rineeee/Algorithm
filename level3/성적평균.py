import sys
input = sys.stdin.readline


n, k = map(int, input().split())
s = list(map(int, input().split()))
for _ in range(k):
    a, b = map(int, input().split())
    print(f'{round(sum(s[a-1:b])/(b-a+1),2):.2f}')
