import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1]*m for _ in range(n)]

def dfs(x, y):
    if x == n-1 and y == m-1:
        return 1

    if dp[x][y] != -1:
        return dp[x][y]

    result = 0
    for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
        nx, ny = x+dx, y+dy
        if 0<=nx<n and 0<=ny<m and arr[nx][ny] < arr[x][y]:
            result += dfs(nx,ny)
    dp[x][y] = result

    return dp[x][y]

print(dfs(0,0))
