import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [[0]*(n+1)]
for _ in range(n):
    arr.append([0]+list(map(int, input().split())))

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            arr[i][j] = min(arr[i][j], arr[i][k]+arr[k][j])

for _ in range(m):
    a, b, c = map(int, input().split())
    if arr[a][b] <= c:
        print("Enjoy other party")
    else:
        print("Stay here")

