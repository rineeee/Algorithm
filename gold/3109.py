import sys
input = sys.stdin.readline

r, c = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(r)]
visited = [[False] * c for _ in range(r)]

def dfs(x, y):
    if y == c-1:
        return True

    for dx, dy in [(-1,1),(0,1),(1,1)]:
        nx, ny = x+dx, y+dy
        if 0<=nx<r and 0<=ny<c and not visited[nx][ny] and arr[nx][ny] != "x":
            visited[nx][ny] = True
            if dfs(nx,ny):
                return True

    return False

answer = 0
for i in range(r):
    if dfs(i, 0):
        answer += 1
print(answer)
