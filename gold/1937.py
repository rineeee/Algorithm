import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]

def dfs(x,y):
    if dp[x][y]:
        return dp[x][y]

    dp[x][y] = 1
    for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
        nx, ny = x+dx, y+dy
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]>arr[x][y]:
            dp[x][y] = max(dp[x][y], dfs(nx,ny) + 1)

    return dp[x][y]

answer =0
for i in range(n):
    for j in range(n):
        if not dp[i][j]:
            answer = max(answer, dfs(i,j))
print(answer)
