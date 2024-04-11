import sys
from collections import deque


input = sys.stdin.readline


m, n, h = map(int, input().split())
arr = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
visited = [[[False]*m for _ in range(n)] for _ in range(h)]

dx = [-1,1,0,0,0,0]
dy = [0,0,-1,1,0,0]
dz = [0,0,0,0,-1,1]
q= deque()

def solution():
    while q:
        x, y, z = q.popleft()

        for i in range(6):
            nx, ny, nz = x+dx[i], y+dy[i], z+dz[i]
            if nx < 0 or nx >= h or ny < 0 or ny >= n or nz < 0 or nz >= m:
                continue

            if arr[nx][ny][nz] == 0 and not visited[nx][ny][nz]:
                q.append((nx, ny, nz))
                arr[nx][ny][nz] = arr[x][y][z] + 1
                visited[nx][ny][nz] = True

for i in range(h):
    for j in range(n):
        for k in range(m):
            if arr[i][j][k] == 1 and not visited[i][j][k]:
                q.append((i,j,k))
                visited[i][j][k] = True

solution()
answer = 0
for a in arr:
    for b in a:
        for c in b:
            if c == 0:
                print(-1)
                exit(0)
        answer = max(answer, max(b))

print(answer-1)

